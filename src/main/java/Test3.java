import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.testng.asserts.SoftAssert;

public class Req3 {

    @Test

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {

            driver.get("https://training.by");

            //positive
            Assert.assertTrue(Boolean.parseBoolean(driver.getCurrentUrl()));


            WebElement clickSignIn = driver.findElement(By.className("header-auth__signin"));
            clickSignIn.click();

            //Hard Assertion negative
            Assert.assertFalse(driver.findElement(By.className("header-auth__signin")).isSelected());

            WebElement enterUserGoogle = driver.findElement(By.id("zocial-google"));
            enterUserGoogle.click();
            WebElement enterUserMail = driver.findElement(By.id("identifierId"));
            enterUserMail.sendKeys("serhii.burch@gmail.com");

            //Boundary values positive
            int text = enterUserMail.getText().length();
            boolean maxText = text <= 64;
            Assert.assertEquals(maxText, true);

            WebElement enterMailNext = driver.findElement(By.tagName("button"));
            enterMailNext.click();

            //positive
            Assert.assertTrue(driver.findElement(By.tagName("button")).equals("button"));

            WebElement enterUserPass = driver.findElement(By.name("password"));
            enterUserPass.sendKeys("dHeTTp9\\HuH");
            WebElement enterPassNext = driver.findElement(By.tagName("button"));
            enterPassNext.click();

            WebElement userName = driver.findElement(By.className("user-info__name"));

            //Soft Assertion negative
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals( driver.findElement(By.name("password")), "user", "First soft assert failed");
            softAssert.assertAll();

        } finally {
            driver.close();
            driver.quit();
        }
    }
}


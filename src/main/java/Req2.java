import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Req2 {

    @Test

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {

            driver.get("https://training.by");
            WebElement clickSignIn = driver.findElement(By.className("header-auth__signin"));
            clickSignIn.click();
            WebElement enterUserGoogle = driver.findElement(By.id("zocial-google"));
            enterUserGoogle.click();
            WebElement enterUserMail = driver.findElement(By.id("identifierId"));
            enterUserMail.sendKeys("serhII.burch@gmail.com");
            enterUserMail.click();
            String ActualTitle = String.valueOf(driver.findElements(By.tagName("data-initial-value")));
            String ExpectedTitle = "serhii.burch@gmail.com";
            Assert.assertEquals(ActualTitle, ExpectedTitle);

        } finally {
            driver.close();
            driver.quit();
        }
    }
}


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Req1 {

    @Test(description = "Verify user is successfully logged in with appropriate credentials")

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\chromdriver_93.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {

            // 1. Open the browser and access the ‘https://training.by’ URL.
            driver.get("https://training.by");

            WebElement clickSignIn = driver.findElement(By.className("header-auth__signin"));
            // 2. Click on ‘Sign In’ button in upper right corner of the window.
            clickSignIn.click();
            // 3. Enter valid user’s mail
            WebElement enterUserGoogle = driver.findElement(By.id("zocial-google"));
            enterUserGoogle.click();
            WebElement enterUserMail = driver.findElement(By.id("identifierId"));
            enterUserMail.sendKeys("serhii.burch@gmail.com");
            // 4. Click Continue button
            WebElement enterMailNext = driver.findElement(By.tagName("button"));
            enterMailNext.click();
            // 5. Enter valid password
            // ?
            WebElement enterUserPass = driver.findElement(By.name("password"));
            enterUserPass.sendKeys("dHeTTp9\\HuH");
            // 6. Click ‘Sign In’ button
            WebElement enterPassNext = driver.findElement(By.tagName("button"));
            enterPassNext.click();

            WebElement userName = driver.findElement(By.className("user-info__name"));
            Assert.assertTrue(userName.isDisplayed(), "Username is NOT displayed");

        } finally {

            driver.close();
            driver.quit();
        }
    }
}


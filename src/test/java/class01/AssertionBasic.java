package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AssertionBasic {
    public static WebDriver driver;

    //preconditions
    @BeforeMethod
    public void SetupBrowser() {
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //

    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
    //testCase
    //enter the username:Admin
    //enter the password :abracadabra
    //click login button
    //verify that the massage invalid credentials is displayed
    //verify that the password text is displayed
    @Test
    public void invalidCredentials(){
        WebElement username=driver.findElement(By.xpath("//input[@name='txtUsername']"));
        username.sendKeys("Admin");
        WebElement password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("abracadabra");

        WebElement loginBtn=driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginBtn.click();
        WebElement error=driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String errorMsg= error.getText();
        String expectedError="Invalid credentials";
        /*
        if (errorMsg.equalsIgnoreCase(expectedError)){
            System.out.println("test passed");
        }
        else {
            System.out.println("test failed");
        }

         */
        //assert the value
        Assert.assertEquals(expectedError,errorMsg);
        //pass text box is displayed
        //finding the password element again as it is discarded when we clicked on login button because
        //the DOM refreshed
        //password text box is displayed
        password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
        boolean passwordDisplayed= password.isDisplayed();
        Assert.assertTrue(passwordDisplayed);
    }
}
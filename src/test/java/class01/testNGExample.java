package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class testNGExample {
    //Test1
    //goto syntax Hrms
    //ENTER THE USERNAME AND PASSWORD,VERIFY THAT U LOGGED IN
    //CLOSE BROWSER
    public static WebDriver driver;
    //pre condition--->to open the browser
    //to set implicit wait


    @BeforeMethod(alwaysRun = true)
    public void SetupBrowser() {
        WebDriverManager.chromiumdriver().setup();
         driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();

    }
    // test case 1
    @Test(groups = "regression")
    public void LoginFunctionality(){
       WebElement username=driver.findElement(By.xpath("//input[@name='txtUsername']"));
       username.sendKeys("Admin");
        WebElement password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginBtn=driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginBtn.click();
}
//testCase2
    //verify that password textbox is displayed on login page
    @Test
    public void passwordTextBoxVerification(){
        WebElement password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
        System.out.println(password.isDisplayed());

    }

        }

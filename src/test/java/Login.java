import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.online.GeckodriverSupport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login {
    WebDriver driver;
    @BeforeClass
    public void OpenChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void ValidCredential(){
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        WebElement succMsg=driver.findElement(By.className("post-title"));
        Assert.assertTrue(succMsg.isDisplayed());
        System.out.println("Valid login successfull");


    }
    @Test(priority = 2)
    public void InvalidCredential(){
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys("Student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        WebElement ErrorMsg=driver.findElement(By.id("error"));
        Assert.assertTrue(ErrorMsg.isDisplayed());
        System.out.println("InValid login unsuccessfull");

    }
    @Test(priority = 3)
    public void EmptyCredential(){
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("submit")).click();

        WebElement ErrorMsg2=driver.findElement(By.id("error"));
        Assert.assertTrue(ErrorMsg2.isDisplayed());
        System.out.println("InValid login unsuccessfull");

    }
    @AfterClass
    public void end(){
        driver.quit();
    }


}

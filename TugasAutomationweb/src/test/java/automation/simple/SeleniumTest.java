package automation.simple;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest {

    WebDriver driver;

    @Test
    public void loginTest() {
        //open browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://yopmail.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Tunggu halaman sampai terinput sempurna
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login\"]")));
        driver.findElement(By.xpath("//*[@id=\"login\"]")).sendKeys("automationtest");
        driver.findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();

        // Switching
        driver.manage().window().maximize();
        driver.switchTo().frame("ifmail"); //switching the frame by ID

        System.out.println("********We are switch to the iframe*******");
        driver.findElement(By.xpath("//div[@class='ellipsis nw b f18']"));

        String txtActualBerhasilswitch = driver.findElement(By.xpath("//h1[contains(.,'Thank you for your order with Comcast Business.')]")).getText();
        String txtExpectedBerhasilswitch= "Thank you for your order with Comcast Business.";
        //        System.out.println(txtActualBerhasilswitch);
        Assert.assertEquals(txtActualBerhasilswitch,txtExpectedBerhasilswitch);

        }

    }

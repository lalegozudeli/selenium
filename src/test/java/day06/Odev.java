package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.time.Duration;

public class Odev {
    /*  Bir Class olusturalim YanlisEmailTesti
        http://automationpractice.com/index.php sayfasina gidelim
        Sign in butonuna basalim
        Email kutusuna @isareti olmayan bir mail yazip enter’a
        bastigimizda “Invalid email address” uyarisi ciktigini test edelim
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void test1(){
       // Sign in butonuna basalim
        driver.findElement(By.xpath("//a[@class='login']")).click();

    }
    @Test
    public void test2(){
       // Email kutusuna @isareti olmayan bir mail yazip enter’a
       WebElement email = driver.findElement(By.id("newsletter-input"));
       email.sendKeys("lgmail.com",Keys.ENTER);

    }
    @Test
    public void test3(){
        //bastigimizda “Invalid email address” uyarisi ciktigini test edelim
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='alert alert-danger']")).isDisplayed());

    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }

}

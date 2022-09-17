package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertion {
    /*
        - amazon sayfasına gideli
        3 farklı test methodu oluşturalım
        a- Url nin amazon içerdiğini test edelim
        b- Tittle in facebook içermediğin test edelim
        c-sol üst köşede amazon logosunın görüldüğünü test edelim
        d- Url nin facebook.com olduğunu test ediniz
        */
    static WebDriver driver;
    @BeforeClass
    public static void setup (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://www.amazon.com");

    }
    @AfterClass
    public static void tearDown(){
        // driver.close();

    }
    @Test
    public void test1(){
       // a- Url nin amazon içerdiğini test edelim

        String expectedUrl= "amazon";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

    }
    @Test
    public void test2(){
        //b- Tittle in facebook içermediğin test edelim

        String actualTitle= driver.getTitle();
        String expectedTitle="facebook";
        Assert.assertFalse(actualTitle.contains(expectedTitle));

    }
    @Test
    public void test3(){
       // c-sol üst köşede amazon logosunın görüldüğünü test edelim
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());

    }
    @Test
     // d- Url nin facebook.com olduğunu test ediniz
    public void test4(){
        String expectedUrl = "www.facebook.com";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(expectedUrl,actualUrl);
    }


}

package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C01_Actions extends TestBaseBeforeAfter {

    @Test
    public void test1(){
        // Automationexercises.com sitesine gidelim
        driver.get("https://automationexercise.com ");
        // Product bölümüne gidelim
        driver.findElement(By.cssSelector("a[href='/products']")).click();
        // ilk ürüne tıklayalım
        /*
        1. yol
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,1000)");
        */
        //2.yol
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.cssSelector("a[data-product-id=\"1\"]")).click();


    }

}

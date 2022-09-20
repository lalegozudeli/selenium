package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import javax.swing.*;

public class C03_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1(){
        // Amazon sayfasına gidelim
        // Account menusunden create a list linkine tıklayalım

        driver.get("https://amazon.com");
        WebElement accoundList =driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accoundList).perform();

        /*
        Bir web sitesinde bir mouse ile acılan bir web elementine ulaşmak istersek
        action.moveToElement() methodunu kullanmamız gerekir aksi taktirde html kodları arasında web
        elementi bulur ama ulaşamadığı için ElementNotInteractableException  hatası verir.
        */

        driver.findElement(By.xpath("//*[text()='Create a List']")).click();


    }

}

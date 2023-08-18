package day09_switchingWindow_actionsClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
public class C05_Actions extends TestBase {
    @Test
    public void test01(){
       /* //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //   mouse’u bu menunun ustune getirin
        Actions actions = new Actions(driver);
        WebElement accountsListMenuElementi= driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        actions.moveToElement(accountsListMenuElementi).perform();
        //3- “Create a list” butonuna basin
        WebElement createListElementi = driver.findElement(By.xpath("//*[text()='Create a List']"));
        createListElementi.click();
        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        WebElement yourListElementi = driver.findElement(By.xpath("//div[@role='heading']"));
        String expectedYazi= "Your Lists";
        String actualYazi= yourListElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);*/


      /* 1- https://www.amazon.com/ adresine gidin
         2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
             mouse’u bu menunun ustune getirin
         3- “Create a list” butonuna basin
         4- Acilan sayfada “Your Lists” yazisi oldugunu test edin */
        driver.get("https://www.amazon.com/");
        Actions actions1=new Actions(driver);
        WebElement createElement=driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        actions1.moveToElement(createElement).perform();
        WebElement clickCreate=driver.findElement(By.xpath("//*[text()='Create a List']"));
        actions1.click(clickCreate).perform();
        WebElement yourListsElementi=driver.findElement(By.xpath("//div[@role='heading']"));
        String expectedElement="Your Lists";
        String actualElement=yourListsElementi.getText();

    }
}
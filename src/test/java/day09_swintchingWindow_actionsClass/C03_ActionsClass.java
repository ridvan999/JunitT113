package day09_swintchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;
import java.time.LocalTime;
import java.util.Set;
public class C03_ActionsClass extends TestBase {
    @Test
    public void test01() throws InterruptedException {
         //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapin
        WebElement ciziliAlan = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(ciziliAlan).perform();
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlertYazisi = "You selected a context menu";
        String actualAlertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        //  linki tikladigimizda yeni window acildigindan
        //  tiklamadan once ilk window'un WHD almamiz gerekir
        String ilkWindowWHD = driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();
        // ikinci sayfa biz newWindow() demeden acildigindan
        // ikinciWindow'un WHD'ini Java kullanarak bulmaliyiz
        String ikinciWindowWHD = "";
        Set<String> windowHDegerleriSeti = driver.getWindowHandles(); // icinde 2 tane WHD var
        // ilkWindowWHD'e esit olmayani ikinciWindowWHD olarak atayalim
        for (String eachWHD : windowHDegerleriSeti
        ) {
            if (!eachWHD.equals(ilkWindowWHD)){
                ikinciWindowWHD=eachWHD;
            }
        }
        driver.switchTo().window(ikinciWindowWHD);
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String expectedYazi="Elemental Selenium";
        WebElement yaziElementi = driver.findElement(By.tagName("h1"));
        String actualYazi= yaziElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);
        Thread.sleep(5000);


     /* //****************************************************************************************
        //  2- https://the-internet.herokuapp.com/context_menu sitesine gidin
            driver.get("https://the-internet.herokuapp.com/context_menu");
        //  3- Cizili alan uzerinde sag click yapin
            WebElement element=driver.findElement(By.xpath("//*[@id=\"hot-spot\"]"));// once yerini bulup kaydettik
            String WHD=driver.getWindowHandle();    // ilerde lazim olur diiye WH degerini kaydettik
            Actions action=new Actions(driver);// sağ click yapabilmek icin action objesi olusturduk
            action.contextClick(element).perform();// locate ini aldigimiz elemente sag clickleyip perform ettik.
                                                   // action classlarda mutlaka en son perform yapmak zorundayiz
        //  4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlertIcerik="You selected a context menu";
        String actualAlertIcerik=driver.switchTo().alert().getText();// html locatini alamadigimiz icin swtichTo().alert() metoduyla devam ettik
        Assert.assertEquals(expectedAlertIcerik,actualAlertIcerik);// test
        //  5- Tamam diyerek alert’i kapatalim
            driver.switchTo().alert().accept();
        //  6- Elemental Selenium linkine tiklayalim
            WebElement seleniumLink=driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
            action.click(seleniumLink).perform();
         // 7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
            Set <String> allWHD=driver.getWindowHandles();// Stringlerden olusan bir set
                                                            // yani whdleri icine kaydetti.ama bunları direkt yazdiramayiz
        String ikinciWHD="";
        for (String each: allWHD
             ) {
            if (!each.equals(WHD));
            ikinciWHD=each;
        }
        driver.switchTo().window(ikinciWHD);
        String expectedYazi="Elemental Selenium";
        WebElement yaziElementi = driver.findElement(By.tagName("h1"));
        String actualYazi= yaziElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);*/


    }

}
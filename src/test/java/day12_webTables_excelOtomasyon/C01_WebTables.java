package day12_webTables_excelOtomasyon;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
import java.util.List;
public class C01_WebTables extends TestBase {
    @Test
    public void test01() throws InterruptedException {

       //1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");
        //2.Sayfanin en altina inin
        Actions actions= new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        //3.Web table tum body’sini yazdirin
        Thread.sleep(2000);
        WebElement tumBodyElementi= driver.findElement(By.tagName("tbody"));
        System.out.println(tumBodyElementi.getText());
        // tum Body'yi tek element olarak locate etmek
        // body icinde gecen bir metnin varligini test etmek gibi gorevler icin kullanilabilir
        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement> satirElementleriList = driver.findElements(By.xpath("//tbody/tr"));
        int expectedSatirSayisi=9;
        int actualSatirsayisi= satirElementleriList.size();
        Assert.assertEquals(expectedSatirSayisi,actualSatirsayisi);
      //5.Tum satirlari yazdirin
         System.out.println("============================");
        for (WebElement eachSatir:satirElementleriList
        ) {
            System.out.println(eachSatir.getText());
            System.out.println("============================");
        }
        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> birinciSatirDatalari=driver.findElements(By.xpath("//tbody/tr[1]/td"));
        int expectedSutunSayisi=13;
        int actualSutunSayisi=birinciSatirDatalari.size();
        Assert.assertEquals(expectedSutunSayisi,actualSutunSayisi);
        //7. 5.sutunu yazdirin
        System.out.println("-----------------------------------");
        List<WebElement> besinciSutunElementleri = driver.findElements(By.xpath("//tbody/tr/td[5]"));
        for (WebElement eachData:besinciSutunElementleri
        ) {
            System.out.println(eachData.getText());
        }
        //8.Satir ve sutun sayisini parametre olarak alip,
        //  hucredeki bilgiyi döndüren bir method olusturun
        System.out.println("................................");
        System.out.println(dataGetir(1,9));
    }
    private String dataGetir(int satirNo, int sutunNo) {
        // //tbody/tr[5]/td[9]
        String dinamikXpath = "//tbody/tr["+satirNo+"]/td["+sutunNo+"]";
        WebElement istenenDataElementi= driver.findElement(By.xpath(dinamikXpath));
        return istenenDataElementi.getText();
    }
}


 /*       //******************KENDİ ÇALIŞMAM**************************
        //***********************************************************
        //  1."https://www.amazon.com" adresine gidin
        //  2.Sayfanin en altina inin
        driver.get("https://www.amazon.com/");
        Actions actions2 = new Actions(driver);
        actions2.sendKeys(Keys.END).perform();
        // 3.Web table tum body’sini yazdirin
        Thread.sleep(2000);
        WebElement tumBodyElementi2 = driver.findElement(By.tagName("tbody"));
        Thread.sleep(2000);
        System.out.println(tumBodyElementi2.getText());
        System.out.println("***********************************************************");
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!////
        //** asagidaki gibi de oluyor. hem de Thread e gerek kalmadan

        //   List<WebElement>tumBodyElement3=driver.findElements(By.tagName("tbody"));
        //    for (WebElement  each: tumBodyElement3
        //         ) {
        //        System.out.println(each.getText());
        //    }
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!////

        //  4.Web table’daki satir sayisinin 9 oldugunu test edin

        List<WebElement> satirElementleri = driver.findElements(By.xpath("//tbody/tr"));
        int expectedSatirSayisi2 = 10;
        int actualSatirSayisi = satirElementleri.size();
        Assert.assertEquals(expectedSatirSayisi2, actualSatirSayisi);
        //  5.Tum satirlari yazdirin
        List<WebElement> satirElementleriList2 = driver.findElements(By.xpath("//tbody/tr"));

        for (WebElement eachSatir : satirElementleriList2
        ) {
            System.out.println(eachSatir.getText());
        }
        //  6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> sutunElementleri = driver.findElements(By.xpath("//tbody/tr[1]/td"));
        int expextedSutunsayisi2 = 13;
        int actualSutunSayisi = sutunElementleri.size();
        //  7. 5.sutunu yazdirin
        System.out.println("**************************************************************************************");
        List<WebElement> sutunDatalari2 = driver.findElements(By.xpath("//tbody//td[5]"));
        for (WebElement each3 : sutunDatalari2
        ) {
            System.out.println(each3.getText());
        }
        //  8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi
        //  döndüren bir method olusturun
        System.out.println("................................");
        System.out.println(dataGetir(1,9));
    }
    private String dataGetir(int satirNo, int sutunNo) {
        // //tbody/tr[5]/td[9]
        String dinamikXpath = "//tbody/tr["+satirNo+"]/td["+sutunNo+"]";
        WebElement istenenDataElementi= driver.findElement(By.xpath(dinamikXpath));
        return istenenDataElementi.getText();
    }
}
*/

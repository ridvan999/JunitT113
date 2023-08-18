package day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TestNotasyonu {
    /*
    Bu class içinde 3 test olusturalim
         1- google anasayfaya gidip urlnin google icerdigini
         2- wisequarter sayfasına gidip urlnin wisequarter icerdigini
         3- amazon sayfasınina gidip amazon logosunun gorundugunu test edin
                        */
    /*
          Junitin bize sagladigi en onemli ozelligi test methodlarinin bagimsiz olarak calistirilabilmesini
          saglayan @Test notasyonudur

          Junitle class level den birden fazla test metodu calistirirsak
          hangi siralama ile calistiracagini ongoremeyiz ve yonetemeyiz

          Diyelim ki bir test methodu uzerinde calisiyorsunuz
          ve o methodun toplu calistirilmalarda kullanilmasini istemiyorsunuz
     */
    WebDriver driver;
    @Test @Ignore
    public void googleTest() {
        // 1- google anasayfaya gidip urlnin google icerdigini
        mahserin4Atlisi();
        driver.get("https://google.com");
        String expectedIcerik="google";
        String actualUrl=driver.getCurrentUrl();
        if (actualUrl.contains(expectedIcerik)){
        System.out.println("google testi PASSED");}
        else {
            System.out.println("google testi FAILED");}

    }
    @Test
    public void wiseTest(){
        //2- wisequarter sayfasına gidip urlnin wisequarter icerdigini
        mahserin4Atlisi();
        driver.get("https://wisequarter.com");
        String expectedIcerik="wisequarter";
        String actualUrl=driver.getCurrentUrl();
        if (actualUrl.contains(expectedIcerik)){
            System.out.println("wisequarter testi PASSED");}
        else {
            System.out.println("wisequarter testi FAILED");}


    }
    @Test

    public void amazonTest(){
        //  3- amazon sayfasınina gidip amazon logosunun gorundugunu test edin
        mahserin4Atlisi();
        driver.get("https://amazon.com");
        WebElement amazonLogosu=driver.findElement(By.xpath("//*[@aria-label='Amazon']"));
        if (amazonLogosu.isDisplayed()){
            System.out.println("amazon logosu gorunur testi Passed");
        }
        else { System.out.println("amazon logosu gorunur testi Failed");

    }



    }
    public void mahserin4Atlisi(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));






    }
}

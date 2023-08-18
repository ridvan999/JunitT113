package day06_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertion {
    /*
     Bir Assertion failed olursa
     Assertion'in oldugu satirda exception olusur
     ve assertion satirindan sonraki kodlar CALISMAZ
  */
    WebDriver driver;
    @Test
    public void googleTest(){
        mahserin4Atlisi();
        // 1- google anasayfaya gidip, url'in google icerdigini test edin
        driver.get("https://google.com/");
        String expectedGoogleUrl="gogle";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedGoogleUrl));

    }
    @Test
    public void wiseTest(){
        // 2- wisequarter anasayfaya gidip url'in wisequarter icerdigini test edin
        mahserin4Atlisi();
        driver.get("https://wisequarter.com/");
        String expectedWiseUrl="wisequarter";
        String actualWiseUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualWiseUrl.contains(expectedWiseUrl));

    }
    @Test
    public void amazonTest(){
        // 3- amazon anasayfaya gidip, amazon logosunun gorundugunu test edin
        mahserin4Atlisi();
        driver.get("https://www.amazon.com");
        String expectedIcerik = "AMAZON";
        String actualTitle= driver.getTitle();
        /*
        if (actualTitle.contains(expectedIcerik)){
            System.out.println("Title testi PASSED");
        }else {
            System.out.println("Actual Title : " + actualTitle);
            System.out.println("Title testi FAILED");
        }
         */
        Assert.assertTrue(actualTitle.contains(expectedIcerik));
    }
    public void mahserin4Atlisi(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
}



package day07_JUnit_dropdown;
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
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
public class C04_DropdownMenu {
    //  https://www.amazon.com/ adresine gidin.
    //- Test 1
    //  Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
    //-Test 2
    //  1. Kategori menusunden Books secenegini  secin
    //  2. Arama kutusuna Java yazin ve aratin
    //  3. Bulunan sonuc sayisini yazdirin
    //  4. Sonucun Java kelimesini icerdigini test edin
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
    @Test
    public void test01(){
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        WebElement dropMenu=driver.findElement(By.id("searchDropdownBox"));
        int expectedCategory=45;
        Select select= new Select(dropMenu);
        int actualCategory= select.getOptions().size();
        Assert.assertEquals(expectedCategory,actualCategory);
        // Element dropdown menu oldugu icin Select class'indan olusturacagimiz
        // obje ile ilgili method'lari kullanmaliyiz
    }
    @Test
    public void test02(){
        //  1. Kategori menusunden Books secenegini  secin //*** Locate ini aldiktan sonra Select objesi olusturarak gidecegiz
        //  2. Arama kutusuna Java yazin ve aratin
        //  3. Bulunan sonuc sayisini yazdirin
        //  4. Sonucun Java kelimesini icerdigini test edin
        WebElement dropDownKutusu=driver.findElement(By.xpath("//*[@aria-describedby='searchDropdownDescription']"));
        Select select=new Select(dropDownKutusu);
        select.selectByVisibleText("Books");
        WebElement searchButon=driver.findElement(By.id("twotabsearchtextbox"));
        searchButon.sendKeys("Java"+ Keys.ENTER);
        WebElement actualelement=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String actualText=actualelement.getText();

        System.out.println(actualText);
        String expectedText= "Java";
        Assert.assertTrue(actualText.contains(expectedText));


    }
}
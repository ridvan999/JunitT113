package day12_webTables_excelOtomasyon;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.util.List;
public class C02_WebTables extends TestBase {
    @Test
    public void test01() {
/*        //  1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //  2. Headers da bulunan basliklari yazdirin
        List<WebElement> basliklarList = driver.findElements(By.xpath("//div[@role='columnheader']"));
        for (WebElement eachHeader: basliklarList
        ) {
            System.out.println(eachHeader.getText());
        }
        //  3. 3.sutunun basligini yazdirin
        System.out.println("3.sutun basligi : " + basliklarList.get(3).getText());
        //  4. Tablodaki tum datalari yazdirin
        System.out.println("===================");
        int bosOlmayanDataSayisi=0;
        List<WebElement> tabloDatalari = driver.findElements(By.xpath("//div[@role='gridcell']"));
        for (WebElement eachData:tabloDatalari
        ) {
            if (!eachData.getText().isBlank()){
                System.out.println(eachData.getText());
                bosOlmayanDataSayisi++;
            }
        }
        //  5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        System.out.println("Tabloda bos olmayan hucre sayisi : " + bosOlmayanDataSayisi);
        //  6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirlarList = driver.findElements(By.xpath("//div[@role='rowgroup']"));
        System.out.println("Tablodaki satir sayisi : " + satirlarList.size());
        //  7. Tablodaki sutun sayisini yazdirin
        System.out.println("tablodaki sutun sayisi : " + basliklarList.size());
        //  8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuSutunElementleri = driver.findElements(By.xpath("(//div[@role='row'])/div[3]"));
        System.out.println("======3.sutun=======");
        for (WebElement eachData:ucuncuSutunElementleri
        ) {
            if (!eachData.getText().isBlank()){
                System.out.println(eachData.getText());
            }
        }
        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        for (int i = 2; i < satirlarList.size() ; i++) {
            WebElement isim = driver.findElement(By.xpath(getDinamikXpath(i,1)));
            if (isim.getText().equalsIgnoreCase("Kierra")){
                WebElement salary= driver.findElement(By.xpath(getDinamikXpath(i,5)));
                System.out.println("Kierra'nin maaasi : " + salary.getText());
            }
        }


        //10. bir method olusturun,
        //    satir ve sutun sayisini girdigimde bana datayi yazdirsin
        dataYazdir(3,3);
    }
    private void dataYazdir(int satirNo, int sutunNo) {
        String dinamikXPath= "(//div[@role='row'])["+satirNo+"]/div["+sutunNo+"]" ;
        WebElement istenenElement= driver.findElement(By.xpath(dinamikXPath));
        System.out.println("Istenen hucredeki data : " + istenenElement.getText());
    }
    public String getDinamikXpath(int satirNo,int sutunNo){

        return "(//div[@role='row'])["+satirNo+"]/div["+sutunNo+"]" ;
        */

        /*
        Bir Class olusturun D19_WebtablesHomework
            3. 3.sutunun basligini yazdirin
            4. Tablodaki tum datalari yazdirin
            5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
            6. Tablodaki satir sayisini yazdirin
            7. Tablodaki sutun sayisini yazdirin
            8. Tablodaki 3.kolonu yazdirin
            9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
            10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
            sayisini girdigimde bana datayi yazdirsin

         */
        // 1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        // 2. Headers da bulunan basliklari yazdirin
        List<WebElement> headerList = driver.findElements(By.xpath("//div[@role='columnheader']"));
        for (WebElement each : headerList
        ) {
            System.out.println("header basliklari:   " + each.getText());
        }
        System.out.println("*******************************************");

        //3. 3.sutunun basligini yazdirin
        System.out.println(headerList.get(2).getText());

        //  4. Tablodaki tum datalari yazdirin
        System.out.println("===================");
        int bosOlmayanDataSayisi = 0;
        List<WebElement> tabloDatalari = driver.findElements(By.xpath("//div[@role='gridcell']"));
        for (WebElement eachData : tabloDatalari
        ) {
            if (!eachData.getText().isBlank()) {
                System.out.println(eachData.getText());
                bosOlmayanDataSayisi++;
            }
        }
        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        System.out.println("bos olmayan data sayisi=  " + bosOlmayanDataSayisi);
        System.out.println("=" + bosOlmayanDataSayisi);
        //   6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElementleri = driver.findElements(By.xpath("//div[@role='rowgroup']"));
        int satirSayisi = 0;
        for (WebElement eachSatir : satirElementleri
        ) {
            satirSayisi++;

        }
        System.out.println("============" + satirSayisi);

        // *** ikinci yol
        // List<WebElement> satirElementleri=driver.findElements(By.xpath("//div[@role='rowgroup']"));

        System.out.println("satir elementleri sayisi=   " + satirElementleri.size());
        // 7. Tablodaki sutun sayisini yazdirin
        System.out.println("sutun sayisi    = " + headerList.size());
        // 8. Tablodaki 3.kolonu yazdirin
        System.out.println("3.kolon liste   : " + headerList.get(2).getText());

        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        for (int i = 2; i < satirElementleri.size() ; i++) {
            WebElement isim = driver.findElement(By.xpath(getDinamikXpath(i,1)));
            if (isim.getText().equalsIgnoreCase("Kierra")){
                WebElement salary= driver.findElement(By.xpath(getDinamikXpath(i,5)));
                System.out.println("Kierra'nin maaasi : " + salary.getText());
            }
        }


        //10. bir method olusturun,
        //    satir ve sutun sayisini girdigimde bana datayi yazdirsin
        dataYazdir(3,3);
    }
    private void dataYazdir(int satirNo, int sutunNo) {
        String dinamikXPath= "(//div[@role='row'])["+satirNo+"]/div["+sutunNo+"]" ;
        WebElement istenenElement= driver.findElement(By.xpath(dinamikXPath));
        System.out.println("Istenen hucredeki data : " + istenenElement.getText());
    }
    public String getDinamikXpath(int satirNo,int sutunNo){

        return "(//div[@role='row'])["+satirNo+"]/div["+sutunNo+"]" ;

   }

}
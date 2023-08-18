package utilities;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static utilities.TestBaseBeforeClass.driver;

public class DinamikXpathMethodOlusturma {
    public static void main(String[] args) {

    }
    @Test
    private void dataYazdir(int satirNo, int sutunNo) {
        String dinamikXPath= "(//div[@role='row'])["+satirNo+"]/div["+sutunNo+"]" ;
        WebElement istenenElement= driver.findElement(By.xpath(dinamikXPath));
        System.out.println("Istenen hucredeki data : " + istenenElement.getText());
    }
    public String getDinamikXpath(int satirNo,int sutunNo){

        return "(//div[@role='row'])["+satirNo+"]/div["+sutunNo+"]" ;

    }
}

package day10_actionsClass_Faker_FileTestleri;
import org.junit.Assert;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
public class C06_DosyaYolunuDinamikYapma {
    @Test
    public void test01(){
        // herkesin bilgisayarinda farkli bir dosya hiyerarsisi oldugundan
        // herkesin dosya yolu birbirinden farkli olur
        // Dosya yolunu dinamik hale getirmek icin Java'dan yardim alacagiz
        //  /Users/ahmetbulutluoz/Downloads/foto.png
        //C:\Users\emre.cigit\Downloads\foto.png"
        //"C:\Users\Berke\Downloads\foto.png"
        System.out.println(System.getProperty("user.dir"));
        // projenin dosya yolunu verir
        //    C:\Users\suti rido\IdeaProjects\com.Team113JUnit
        System.out.println(System.getProperty("user.home"));
        //  C:\Users\suti rido
        /* biz Downloads'a indirdigim dosyanin dosya yolunu 2'ye bolecegiz
            /Users/ahmetbulutluoz               /Downloads/foto.png
            herkesin bilgisayarinda farkli      herkeste ayni
            System.getProperty("user.home")     /Downloads/foto.png
         */
        String dosyaYoluDegisenKisim = System.getProperty("user.home");
        System.out.println(dosyaYoluDegisenKisim);
        String dosyaYoluherkesteAyniOlanKisim = "\\Downloads\\USA.png\\";
        System.out.println(dosyaYoluherkesteAyniOlanKisim);
        String dosyaYolu= dosyaYoluDegisenKisim + dosyaYoluherkesteAyniOlanKisim;
        System.out.println(dosyaYolu);
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        // ayni islemi projemizin altindaki deneme.txt icin yapsak
        // src/test/java/day10_actionsClass_Faker_FileTestleri/deneme.txt
        dosyaYoluDegisenKisim = System.getProperty("user.dir");
        dosyaYoluherkesteAyniOlanKisim = "\\src\\test\\java\\day10_actionsClass_Faker_FileTestleri\\C06_DosyaYolunuDinamikYapma.java";
        dosyaYolu = dosyaYoluDegisenKisim + dosyaYoluherkesteAyniOlanKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
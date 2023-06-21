package techproed.tests.excelautomation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Day23_ExcelLogin {

    //sam.walker@bluerentalcars.com  c!fas_art
    //kate.brown@bluerentalcars.com  tad1$Fas
    //raj.khan@bluerentalcars.com  v7Hg_va^
    //pam.raymond@bluerentalcars.com  Nga^g6!

    //------------
    //HOME PAGE'DEYIZ
    //home page login'e tikla
    //kullanici adini gir (Excel'den al)
    //kullanici sifresini gir (Excel'den al)
    //login page'deki login butonuna tikla
    //------------
    //kullanici id ye tikla
    //logout a tikla
    //ok e tikla

    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    public void login(){
        blueRentalLoginPage = new BlueRentalLoginPage();
        blueRentalHomePage = new BlueRentalHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("blue_rental_car_url"));
        try {
            blueRentalHomePage.loginButton.click();
        }catch (Exception e){
            blueRentalHomePage.userId.click();
            blueRentalHomePage.logoutButton.click();
            blueRentalHomePage.okButton.click();
            blueRentalHomePage.loginButton.click();
        }
    }

    ExcelUtils excelUtils;
    List<Map<String, String>> excelData;
    @Test
    public void testName() throws IOException {
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";
        excelUtils = new ExcelUtils(path, sheetName);
        excelData = excelUtils.getDataList();
        for (Map<String, String> w : excelData){
            login();
            blueRentalLoginPage.emailBox.sendKeys(w.get("username"));
            blueRentalLoginPage.passwordBox.sendKeys(w.get("password"));
            blueRentalLoginPage.loginButton.click();
            ReusableMethods.waitFor(1);
            ReusableMethods.verifyElementDisplayed(blueRentalHomePage.userId);
            ReusableMethods.takeScreenshotOfPage("Screenshot");
        }
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

    //1-Şu anda bulunduğunuz şirket, proje ve kendinizle ilgili bilgi verir misiniz?
    //2-Hangi tool ları kullanıyorsunuz?
    //3-Hangi annotasyonlari kullanıyorsunuz?
    //4-Page Object Model nedir- detay vererek anlatır mısınız?
    //5-Singleton driver ne demektir?
    //6-TestNG de ne tür assertion lar var junit dekilerle farkı nedir?
    //7-Datalari aldığınız kişiler ya da yerler nelerdir. dataları nereden alırsınız?
    //8-Java da kendinize 10 üzerinden kaç verirsiniz?
    //9-Şuan bulunduğunuz şirketteki problemler nelerdir?
    //10-Versiyon kontrol sistemi olarak ne kullanıyorsunuz?
    //11-Yeni yazdığınız kodları git'e nasıl gönderirsiniz?
    //12-Config yaşadınız mı?
    //13-Bir sayfa düşünün loginle alakalı bir user story i baştan sona kadar olan tüm süreçleri anlatabilir misiniz(sprint başladı user story size assign edildi tüm adımları)
    //14-Ne kullanıyorsunuz(jira)
    //15-Test case yazarken çok hata bulur musunuz?
    //16-Hata bulduğunuzda ne yaparsınız(manuel test buldunuz report ettiniz sonrasında ne yaparsınız)
    //17-Sprint bitti hala sorun çözülmedi bu durumda ne yaparsınız.(o user story kapatılıyor mu)

}

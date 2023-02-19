package techproed.tests.practice;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.AmazonHomePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day01_PageKullanimi {

    //Amazona gidelim
    //iphone aratalim
    //sonuc yazisinin iphone icerdigini test edelim

    AmazonHomePage amazonPage;
    @Test
    public void testName() {
        amazonPage = new AmazonHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        amazonPage.searchBox.sendKeys("iphone", Keys.ENTER);
        Assert.assertTrue(amazonPage.resultWriting.getText().contains("iphone"));
        Driver.closeDriver();
    }

    //1-Bu zamana kadar teknik konularda neler yaptınız bahseder misiniz?
    //2-Çalıştığınız metodoloji neydi? Takımınızda kaç kişi vardı?
    //3-Kaç scrum master var takımınızda?
    //4-Java konusunda kendinize kaç puan verirsiniz?
    //5-Seleniumda kendinize kaç puan verirsiniz?
    //6-Seleniumla alakalı sizin tercih ettiğiniz elemanları hangi locater lar ile bulursunuz?
    //7-Page Object Model nedir?
    //8-Şuandaki projenizde smoke test yapıyor musunuz? Kaç tane testiniz var smoke testte? Test caseler hangi fonksiyonlarla ilgili?
    //9-Seleniumda otomasyonda yaşadığınız zorluklar nelerdir?
    //10-Seleniumda almış olduğunuz Exception'lar nelerdir?
    //11-Time out exception'u ne zaman alırsınız?
    //12-Diyelim ki testiniz fail oldu steal exception aldınız ne yaparsınız bu durumu çözmek için?
    //13-Static java da nedir, şuan kullandığın framework de(seleniumda) ne için kullanılır?
    //14-Static variable neden static yapılabilir?
    //15-Static bir String ve non-static String var bu ikisinin son değeri tutma açısındaki farklılık nedir?
    //16-Static variable ın son değeri tutucu özelliği var mıdır?
    //17-Static'i kullandığınız yerlerden örnek verir misiniz?(framework de)
    //18-Senaryo sorusu: bir sayfa hayal edin. sayfada çok fazla data oluşturulmuş, diğer sayfaya geçilmek zorunda kalınmış.
    //en son sayfadaki en son elementin değerini almak istiyorum.(mesela 2 bin insanı siteye koymak istiyorum, bir sayfaya 10 kişi sığıyor
    //yenisayfaya geçilmiş). Ne yapmalıyım?

}

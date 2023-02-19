package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TechproHomePage;
import techproed.pages.TechproLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day21_TechproLoginPage {

    @Test(groups = "regression-tests")
    public void testName() throws InterruptedException {
        TechproLoginPage techproLoginPage = new TechproLoginPage();
        TechproHomePage techproHomePage = new TechproHomePage();

        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("test_center_url"));

        //Page object Model kullanarak sayfaya giriş yapildigini test edin
        techproLoginPage.username.sendKeys(ConfigReader.getProperty("test_center_username"));
        techproLoginPage.password.sendKeys(ConfigReader.getProperty("test_center_password"));
        techproLoginPage.submitButton.click();
        Thread.sleep(5000);
        Assert.assertTrue(techproHomePage.homeHeader.isDisplayed());

        //Sayfadan cikis yap ve cikis yapildigini test et
        techproHomePage.homeLogoutButton.click();
        Assert.assertTrue(techproLoginPage.username.isDisplayed());
        Driver.closeDriver();
    }

    //SMOKE TEST
    //Smoke Test nedir? : Uygulamanin stabil durumda oldugu, ve en onemli özelliklerin calisir oldugu test edilir.(Uygulamanin en onemli fonksiyonlari test edilir)
    //Login
    //Check in
    //Checkout
    //Add to card
    //Make payment
    //Sign out
    //……
    //Ne sıklıkla yapılır?
    //Her sabah 8 am civarı
    //Ne kadar surer?
    //15-20 dakika (Smoke testin mantigi su araba calisiyor mu, yoksa bagaji aciliyor mu falan bakilmaz..)
    //Smoke Test i nasıl yaparsın?
    //Smoke test suite klasorumuz var. Bu klasordeki test leri hergun calistiririz. Aslinda jenkins her sabah 8 am de smoke testleri calistirir ve raporları takıma email
    //atar. Testerlar bu raporu inceler ve fail varsa takıma email atar. Virtual Machine(VM-Sanal Bilgisayar) test caselerin calismasi icin kullanilabilir.
    //Smoke test suite de kac test case iniz var?
    //18 tane
    //Tum smoke test caseleriniz automate edilmis midir? Manual de var midir?
    //Tum onemli test case ler automate edilmiştir.
    //Hangi testlerin smoke test e eklenecegine kim karar verir?
    //Test Lead, Sr. Automation Testers. QA. En kidemli tester.

    //REGRESSION TEST
    //Regression Test Nedir? : Tum major, onemli fonksiyonların test edildiği testlerdir. Regression kapsamlı bir testtir; Smoke testler once yapilir(musteri profili ile yapilir) +
    //diger müşteri hizmetleri, admin, tech support(ek olarak profilleri ile de yapilir) + farkli odeme sistemleri(PayPal, amex, visa, Mastercard, WU, BTC,…)
    //Ne sıklıkla yapılır?
    //Production bug fix lerden sonra
    //Major(ana) release lerden once
    //Biz 6 ayda bir major release yapariz ve bu release lerden once regression test yapılır
    //Ne kadar surer?
    //6-7 saat surer
    //Bazi regression test case ler automate edilmemiş ise o zaman manual test gerekir. Bu durumda test suresi uzar.
    //Regression suite nizde kac test case iniz var?
    //400 den fazla test case var
    //Tum regression test case leriniz automate edilmis midir? Manual de var midir?
    //Takim olarak hedefimiz tum regression test case lerin automate edilmesidir. Fakat, bu çok mumkun olmuyor. Genelde %80 den fazla oranda automate ediyoruz.
    //Hangi testlerin regression test e eklenecegine kim karar verir?
    //Test Lead, Sr. Automation Testers. QA.  En kidemli tester.
    //Automate edilemeyen bir durum belirtir misiniz?
    //Dogrulama gerektiren story leri automate edemiyoruz. Cunku doğrulama mobil uygulamaya geliyor.
    //Asiri guvenlikli durumlar.
    //Bazi teknik user storyler sadece developer larla alakalı olabiliyor. Tester larin onların kullandigi environment lara access leri olmayabiliyor. Dolayisiyla bu gibi durumlarda
    //biz automate edemiyoruz.

}

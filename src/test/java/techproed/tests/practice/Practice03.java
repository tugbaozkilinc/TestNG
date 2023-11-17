package techproed.tests.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.pages.HerOkuPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Practice03 {

    //1.https://id.heroku.com/login sayfasina gidin
    //2.Data provider kullanarak mail adres ve passwordleri giriniz
    //3.Login butonuna tiklayiniz
    //4."There was a problem with your login." texti gorunur olduğunu test edin
    //5.sayfalari kapatiniz

    @DataProvider
    public Object[][] user() {
        return new Object[][]{{ConfigReader.getProperty("heroku_invalid_email1"), ConfigReader.getProperty("heroku_invalid_password1")},
                              {ConfigReader.getProperty("heroku_invalid_email2"), ConfigReader.getProperty("heroku_invalid_password2")},
                              {ConfigReader.getProperty("heroku_invalid_email3"), ConfigReader.getProperty("heroku_invalid_password3")}};
    }

    HerOkuPage herOkuPage;
    @Test(dataProvider = "user")
    public void negativeTest(String email, String password) {
        herOkuPage = new HerOkuPage();
        Driver.getDriver().get(ConfigReader.getProperty("heroku_url"));
        herOkuPage.emailBox.sendKeys(email);
        ReusableMethods.waitFor(1);
        herOkuPage.passwordBox.sendKeys(password);
        ReusableMethods.waitFor(1);
        herOkuPage.loginButton.click();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(herOkuPage.errorMessage.isDisplayed());
        Driver.closeDriver();
        softAssert.assertAll();
    }

}

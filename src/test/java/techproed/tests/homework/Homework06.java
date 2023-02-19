package techproed.tests.homework;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.FacebookLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Homework06 {

    //https://www.facebook.com/ adresine gidin
    //POM’a uygun olarak email, sifre kutularini doldurun ve giris yap butonunu locate edin
    //Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
    //Basarili giris yapilamadigini test edin

    FacebookLoginPage facebookLoginPage;
    @Test
    public void facebookTest() {
        facebookLoginPage = new FacebookLoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("facebook_url"));
        Faker faker = new Faker();
        facebookLoginPage.emailBox.sendKeys(faker.internet().emailAddress());
        facebookLoginPage.passwordBox.sendKeys(faker.internet().password());
        facebookLoginPage.loginButton.click();
        Assert.assertTrue(facebookLoginPage.firstErrorMessage.isDisplayed());
    }

}

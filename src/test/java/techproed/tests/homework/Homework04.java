package techproed.tests.homework;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Homework04 {

    //Name:
    //US100402_Negative_Login
    //Description:
    //Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapılamamalı
    //Acceptance Criteria:
    //Kullanici dogru email ve yanlis sifre girildiginde, hata mesajini alınmalı
    //https://www.bluerentalcars.com/
    //Hata Mesaji:
    //Bad credentials
    //Test Data:
    //Customer email: jack@gmail.com
    //Customer password: fakepass

    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    @Test
    public void US100402_Negative_Login() throws InterruptedException {
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("blue_rental_car_url"));
        blueRentalHomePage.loginButton.click();
        blueRentalLoginPage.emailBox.sendKeys(ConfigReader.getProperty("blue_rental_car_email"));
        blueRentalLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("blue_rental_car_fake_password"));
        blueRentalLoginPage.loginButton.click();
        Thread.sleep(2000);
        assert blueRentalLoginPage.errorMessageSecond.isDisplayed();
        Driver.closeDriver();
    }

}

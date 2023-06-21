package techproed.tests.homework;

import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Homework05 {

    //Name:
    //US101122_Negative_Login
    //Description:
    //Geçerli email uzantısı olmadan kullanıcı girişi yapılamamalı
    //Acceptance Criteria:
    //Kullanici geçersiz email uzantısı yazdiginda, hata mesajini almalı
    //Error Message: email must be a valid email
    //Dogru email uzantisi girildiğinde hata mesajı alınmamalı
    //https://www.bluerentalcars.com/

    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    @Test
    public void US101122_Negative_Login() {
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("blue_rental_car_url"));
        blueRentalHomePage.loginButton.click();
        blueRentalLoginPage.emailBox.sendKeys(ConfigReader.getProperty("blue_rental_car_invalid_email"));
        ReusableMethods.waitFor(2);
        assert blueRentalLoginPage.firstErrorMessage.isDisplayed();
        Driver.closeDriver();
    }

}

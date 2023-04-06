package techproed.tests.smoketests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day22_PositiveLoginTest {

    //Name: US100201_Admin_Login
    //Description:
    //Admin bilgileriyle giriş
    //Acceptance Criteria:
    //Admin olarak, uygulamaya giriş yapabilmeliyim
    //https://www.bluerentalcars.com/
    //Admin email: jack@gmail.com
    //Admin password: 12345

    BlueRentalLoginPage blueRentalLoginPage;
    BlueRentalHomePage blueRentalHomePage;
    @Test
    public void US100201_Admin_Login() {
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();
        Reporter.log("GO TO WEB PAGE"); //Log4J2 daki islemleri bu sekilde TestNG report ile de yapabiliriz. Log4J2 TestNG de kullanilabilir, fakat bu islem sadece TestNG report a aittir.
                                           //Fakat bu mesajlari Log4J2 daki gibi consolda degil raporda gorursun.
        Driver.getDriver().get(ConfigReader.getProperty("blue_rental_car_url"));
        Reporter.log("CLICK ON THE LOGIN BUTTON");
        blueRentalHomePage.loginButton.click();
        Reporter.log("ENTER YOUR ACCESS INFORMATION");
        blueRentalLoginPage.emailBox.sendKeys(ConfigReader.getProperty("blue_rental_car_email"));
        blueRentalLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("blue_rental_car_password"));
        blueRentalLoginPage.loginButton.click();
        Reporter.log("ASSERT THE ENTRY IS OK");
        Assert.assertTrue(blueRentalHomePage.userId.isDisplayed());
        Reporter.log("CLOSE THE DRIVER");
        Driver.closeDriver();
    }

}

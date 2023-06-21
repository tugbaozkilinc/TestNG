package techproed.tests.smoketests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Day22_NegativeLoginTest {

    //Name:
    //US100208_Negative_Login
    //Description:
    //User should not be able to log in with incorrect credentials
    //Acceptance Criteria:
    //As customer, I should not be able to log in the application
    //Customer email: fake@bluerentalcars.com
    //Customer password: fakepass
    //Error message: User with email fake@bluerentalcars.com not found

    BlueRentalLoginPage blueRentalLoginPage;
    BlueRentalHomePage blueRentalHomePage;
    @Test
    public void US100208_Negative_Login() {
        blueRentalLoginPage = new BlueRentalLoginPage();
        blueRentalHomePage = new BlueRentalHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("blue_rental_car_url"));
        blueRentalHomePage.loginButton.click();
        blueRentalLoginPage.emailBox.sendKeys(ConfigReader.getProperty("blue_rental_car_fake_email"));
        blueRentalLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("blue_rental_car_fake_password"));
        blueRentalLoginPage.loginButton.click();
        ReusableMethods.waitFor(2);
        Assert.assertEquals(blueRentalLoginPage.errorMessageFirst.getText(), "User with email fake@bluerentalcars.com not found");
        Driver.closeDriver();
    }

}

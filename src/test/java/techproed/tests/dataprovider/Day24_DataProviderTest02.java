package techproed.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Day24_DataProviderTest02 {

    @DataProvider
    public Object[][] customerData(){
        return new Object[][]{
                {"sam.walker@bluerentalcars.com", "c!fas_art"},
                {"kate.brown@bluerentalcars.com", "tad1$Fas"},
                {"raj.khan@bluerentalcars.com", "v7Hg_va^" },
                {"pam.raymond@bluerentalcars.com", "Nga^g6!"},
        };
    }

    @Test(dataProvider = "customerData")
    public void dataProviderTest(String email, String password) {
        System.out.println("Email: " + email + " |Password: " + password);
    }

    //Bu data lar ile login testi yapalim

    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    @Test(dataProvider = "customerData")
    public void testName(String email, String password) {
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("blue_rental_car_url"));
        blueRentalHomePage.loginButton.click();
        blueRentalLoginPage.emailBox.sendKeys(email);
        blueRentalLoginPage.passwordBox.sendKeys(password);
        blueRentalLoginPage.loginButton.click();
        ReusableMethods.waitFor(1);
        ReusableMethods.verifyElementDisplayed(blueRentalHomePage.userId);
        ReusableMethods.takeScreenshotOfPage("Screenshot");
        blueRentalHomePage.userId.click();
        blueRentalHomePage.logoutButton.click();
        blueRentalHomePage.okButton.click();
        Driver.closeDriver();
    }

}

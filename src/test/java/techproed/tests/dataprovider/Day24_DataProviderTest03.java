package techproed.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class Day24_DataProviderTest03 {

    //Excel Data => Data Provider => TestMethod

    @DataProvider
    public Object[][] customerData(){
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
        String sheet = "customer_info";
        ExcelUtils excelUtils = new ExcelUtils(path, sheet);
        Object[][] customerInformation = excelUtils.getDataArrayWithoutFirstRow();
        return customerInformation;
    }

    //Bu data lar ile login testi yapalim

    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    @Test(dataProvider = "customerData")
    public void testName(String email, String password) throws IOException {
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

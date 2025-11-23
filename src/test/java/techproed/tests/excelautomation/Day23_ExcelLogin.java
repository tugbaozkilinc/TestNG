package techproed.tests.excelautomation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;
import java.util.List;
import java.util.Map;

public class Day23_ExcelLogin {

    //HOME PAGE'DEYIZ
    //home page login'e tikla
    //kullanici adini gir (Excel'den al)
    //kullanici sifresini gir (Excel'den al)
    //login page'deki login butonuna tikla
    //------------
    //kullanici id ye tikla
    //logout a tikla
    //ok e tikla

    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    public void login(){
        blueRentalLoginPage = new BlueRentalLoginPage();
        blueRentalHomePage = new BlueRentalHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("blue_rental_car_url"));
        try {
            blueRentalHomePage.loginButton.click();
        }catch (Exception e){
            blueRentalHomePage.userId.click();
            blueRentalHomePage.logoutButton.click();
            blueRentalHomePage.okButton.click();
            blueRentalHomePage.loginButton.click();
        }
    }

    ExcelUtils excelUtils;
    List<Map<String, String>> excelData;
    @Test
    public void testName() {
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";
        excelUtils = new ExcelUtils(path, sheetName);
        excelData = excelUtils.getDataList();
        for (Map<String, String> w : excelData){
            login();
            blueRentalLoginPage.emailBox.sendKeys(w.get("username"));
            blueRentalLoginPage.passwordBox.sendKeys(w.get("password"));
            blueRentalLoginPage.loginButton.click();
            ReusableMethods.waitFor(1);
            ReusableMethods.verifyElementDisplayed(blueRentalHomePage.userId);
            ReusableMethods.takeScreenshotOfPage("Screenshot");
        }
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

}

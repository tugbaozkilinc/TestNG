package techproed.tests.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.pages.ZeroWebAppSecurityHomePage;
import techproed.pages.ZeroWebAppSecurityLoginPage;
import techproed.pages.ZeroWebAppSecurityMakePaymentsPage;
import techproed.pages.ZeroWebAppSecurityPayBillsPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Homework03 {

    //“http://zero.webappsecurity.com/” adresine gidin
    //Sign in butonuna basin
    //Login kutusuna “username” yazin, Password kutusuna “password” yazin Sign in tusuna basin
    //Online banking menusu icinde Pay Bills sayfasina gidin
    //“Purchase Foreign Currency” tusuna basin
    //“Currency” drop down menusunden Eurozone (Euro)’u secin
    //soft assert kullanarak "Eurozone (Euro)" secildigini test edin
    //soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin: "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)", "China
    //(yuan)", "Denmark (krone)", "Eurozone (euro)", "Great Britain (pound)", "Hong Kong (dollar)", "Japan (yen)", "Mexico (peso)", "Norway (krone)", "New Zealand (dollar)",
    //"Sweden (krona)", "Singapore (dollar)", "Thailand (baht)"

    ZeroWebAppSecurityHomePage zeroWebAppSecurityHomePage;
    ZeroWebAppSecurityLoginPage zeroWebAppSecurityLoginPage;
    ZeroWebAppSecurityPayBillsPage zeroWebAppSecurityPayBillsPage;
    ZeroWebAppSecurityMakePaymentsPage zeroWebAppSecurityMakePaymentsPage;
    @Test
    public void test01() {
        zeroWebAppSecurityHomePage = new ZeroWebAppSecurityHomePage();
        zeroWebAppSecurityLoginPage = new ZeroWebAppSecurityLoginPage();
        zeroWebAppSecurityPayBillsPage = new ZeroWebAppSecurityPayBillsPage();
        zeroWebAppSecurityMakePaymentsPage = new ZeroWebAppSecurityMakePaymentsPage();
        Driver.getDriver().get(ConfigReader.getProperty("zero_web_app_security_url"));
        zeroWebAppSecurityHomePage.signInButton.click();
        zeroWebAppSecurityLoginPage.loginBox.sendKeys(ConfigReader.getProperty("zero_web_app_security_username"));
        zeroWebAppSecurityLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("zero_web_app_security_password"));
        zeroWebAppSecurityLoginPage.signInButton.click();
        Driver.getDriver().navigate().back();
        zeroWebAppSecurityHomePage.onlineBankingButton.click();
        zeroWebAppSecurityPayBillsPage.payBillsButton.click();
        zeroWebAppSecurityMakePaymentsPage.purchaseForeignCurrencyButton.click();
        Select select = new Select(zeroWebAppSecurityMakePaymentsPage.currencyDropdown);
        select.selectByValue("EUR");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(select.getFirstSelectedOption().getText(), "Eurozone (euro)");
        softAssert.assertAll();
        List<WebElement> list = zeroWebAppSecurityMakePaymentsPage.currencyDropdownBox;
        List<String> expectedList = new ArrayList<>(Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)", "China (yuan)", "Denmark (krone)",
                                    "Eurozone (euro)", "Great Britain (pound)", "Hong Kong (dollar)", "Japan (yen)", "Mexico (peso)", "Norway (krone)", "New Zealand (dollar)", "Sweden (krona)",
                                    "Singapore (dollar)", "Thailand (baht)"));
        for (String s : expectedList) {
            for (WebElement webElement : list) {
                softAssert.assertEquals(webElement.getText(), s);
            }
        }
        Driver.closeDriver();
    }

}

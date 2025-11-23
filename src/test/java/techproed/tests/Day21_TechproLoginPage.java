package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TechproHomePage;
import techproed.pages.TechproLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Day21_TechproLoginPage {

    TechproLoginPage techproLoginPage;
    TechproHomePage techproHomePage;
    @Test(groups = "regression-tests")
    public void testName() {
        techproLoginPage = new TechproLoginPage();
        techproHomePage = new TechproHomePage();
        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("test_center_url"));

        //Page object Model kullanarak sayfaya giriş yapildigini test edin
        techproLoginPage.username.sendKeys(ConfigReader.getProperty("test_center_username"));
        techproLoginPage.password.sendKeys(ConfigReader.getProperty("test_center_password"));
        techproLoginPage.submitButton.click();
        ReusableMethods.waitFor(5);
        Assert.assertTrue(techproHomePage.homeHeader.isDisplayed());

        //Sayfadan cikis yap ve cikis yapildigini test et
        techproHomePage.homeLogoutButton.click();
        Assert.assertTrue(techproLoginPage.username.isDisplayed());
        Driver.closeDriver();
    }

}

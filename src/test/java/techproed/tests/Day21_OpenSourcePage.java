package techproed.tests;

import org.testng.annotations.Test;
import techproed.pages.OpenSourceDashboardPage;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day21_OpenSourcePage {

    //1. https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
    //2. KullaniciAdi, kullaniciSifre, submitButton elementlerini bul
    //3. Login Testinin basarili oldugunu test et

    OpenSourcePage openSourcePage;
    OpenSourceDashboardPage openSourceDashboardPage;
    @Test
    public void openSourceLogin() throws InterruptedException {
        openSourcePage = new OpenSourcePage();
        openSourceDashboardPage = new OpenSourceDashboardPage();
        Driver.getDriver().get(ConfigReader.getProperty("open_source_url"));
        openSourcePage.username.sendKeys(ConfigReader.getProperty("open_source_username"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("open_source_password"));
        openSourcePage.submitButton.click();
        Thread.sleep(1000);
        assert openSourceDashboardPage.dashboardHeader.isDisplayed();
        Driver.closeDriver();
    }

}

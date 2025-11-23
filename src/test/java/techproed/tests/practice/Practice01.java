package techproed.tests.practice;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.AmazonHomePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Practice01 {

    //Amazona gidelim
    //iphone aratalim
    //sonuc yazisinin iphone icerdigini test edelim

    AmazonHomePage amazonPage;
    @Test
    public void testName() {
        amazonPage = new AmazonHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        amazonPage.searchBox.sendKeys("iphone", Keys.ENTER);
        Assert.assertTrue(amazonPage.resultWriting.getText().contains("iphone"));
        Driver.closeDriver();
    }

}

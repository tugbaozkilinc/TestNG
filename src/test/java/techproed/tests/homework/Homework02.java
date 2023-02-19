package techproed.tests.homework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.AmazonHomePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Homework02 {

    //https://www.amazon.com/ adresine gidin.
    //Amazon ana sayfaya gittiginizi test edin

    @Test
    public void dependsOnTest1() {
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.amazon.com/");
    }

    //1.Test basarili ise search Box’i kullanarak “Nutella” icin arama yapin ve aramanizin gerceklestigini Test edin
    //Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $16.83 olmadigini test edin

    AmazonHomePage amazonHomePage;
    @Test (dependsOnMethods = "dependsOnTest1")
    public void dependsOnTest2() {
        amazonHomePage = new AmazonHomePage();
        amazonHomePage.searchBox.sendKeys("Nutella", Keys.ENTER);
        Assert.assertTrue(amazonHomePage.resultWriting.isDisplayed());
        amazonHomePage.firstProduct.click();
        Driver.closeDriver();
    }

}

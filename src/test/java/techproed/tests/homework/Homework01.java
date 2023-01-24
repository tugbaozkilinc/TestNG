package techproed.tests.homework;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Homework01 {

    @Test
    public void youtubeAssertionsTest() {
        // https://www.youtube.com adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("youtube_url"));

        // Sayfa başlığının “YouTube” oldugunu test edin
        Assert.assertEquals(Driver.getDriver().getTitle(), "YouTube");

        // YouTube resminin görüntülendiğini (isDisplayed()) test edin
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("(//*[@id='logo-icon'])[1]")).isDisplayed());

        // Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//input[@id='search']")).isEnabled());

        // Sayfa basliginin “youtube” olmadigini dogrulayin
        Assert.assertNotEquals(Driver.getDriver().getTitle(), "youtube");

        Driver.closeDriver();
    }

}

package techproed.tests.homework;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.YoutubeHomePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Homework01 {

    //https://www.youtube.com adresine gidin
    //Sayfa başlığının “YouTube” oldugunu test edin
    //YouTube resminin görüntülendiğini(isDisplayed()) test edin
    //Search Box' in erisilebilir oldugunu test edin (isEnabled())
    //Sayfa basliginin “youtube” olmadigini dogrulayin

    YoutubeHomePage youtubeHomePage;
    @Test
    public void youtubeAssertionsTest() {
        youtubeHomePage = new YoutubeHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("youtube_url"));
        Assert.assertEquals(Driver.getDriver().getTitle(), "YouTube");
        Assert.assertTrue(youtubeHomePage.youtubeLogo.isDisplayed());
        Assert.assertTrue(youtubeHomePage.searchBox.isEnabled());
        Assert.assertNotEquals(Driver.getDriver().getTitle(), "youtube");
        Driver.closeDriver();
    }

}

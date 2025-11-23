package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day20_Driver_Config_Test {

    //Amazona git
    //Title in Amazon icerdigini test et

    @Test
    public void testName() {
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Amazon"));
        Driver.closeDriver();
    }

}

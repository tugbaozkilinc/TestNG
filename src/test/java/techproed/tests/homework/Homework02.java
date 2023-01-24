package techproed.tests.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Homework02 {

    @Test
    public void dependsOnTest1() {
        // https://www.amazon.com/ adresine gidin.
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));

        // Amazon ana sayfaya gittiginizi test edin
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.amazon.com/");
    }

    @Test (dependsOnMethods = "dependsOnTest1")
    public void dependsOnTest2() {
        // 1.Test basarili ise search Box’i kullanarak “Nutella” icin arama yapin ve aramanizin gerceklestigini Test edin
        Driver.getDriver().findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Nutella", Keys.ENTER);
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).isDisplayed());

        //Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $16.83 olmadigini test edin
        Driver.getDriver().findElement(By.xpath("(//*[@class='s-image'])[1]")).click();
        Assert.assertNotEquals(Driver.getDriver().findElement(By.xpath("(//*[@class='a-offscreen'])[6]")).getText(), "$16.83");
        Driver.closeDriver();
    }

}

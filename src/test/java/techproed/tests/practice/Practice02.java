package techproed.tests.practice;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import techproed.pages.DhtmlGoodiesHomePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Practice02 {

    DhtmlGoodiesHomePage dhtml;
    @Test
    public void countryTest() {
        dhtml = new DhtmlGoodiesHomePage();
        //http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("dhtml_url"));

        //Tüm ülkeleri yazdırınız
        dhtml.countries.forEach(t -> System.out.println(t.getText()));

        //Ülkeler ile şehirleri eşleştiriniz
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(dhtml.Seoul, dhtml.Korea).
                dragAndDrop(dhtml.Oslo, dhtml.Norway).
                dragAndDrop(dhtml.Stockholm, dhtml.Sweden).
                dragAndDrop(dhtml.Washington, dhtml.Abd).
                dragAndDrop(dhtml.Rome, dhtml.Italy).
                dragAndDrop(dhtml.Madrid, dhtml.Spain).
                dragAndDrop(dhtml.Copenhagen, dhtml.Denmark).build().perform();
    }

}

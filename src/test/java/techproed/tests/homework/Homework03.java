package techproed.tests.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Homework03 {

    @Test
    public void test01() {
        // “http://zero.webappsecurity.com/” adresine gidin
        Driver.getDriver().get("http://zero.webappsecurity.com/");

        // Sign in butonuna basin
        Driver.getDriver().findElement(By.xpath("//*[@id='signin_button']")).click();

        // Login kutusuna “username” yazin
        // Password kutusuna “password” yazin
        // Sign in tusuna basin
        Driver.getDriver().findElement(By.xpath("//*[@id='user_login']")).sendKeys("username", Keys.TAB, "password", Keys.TAB, Keys.TAB, Keys.ENTER);
        Driver.getDriver().navigate().back();

        // Online banking menusu icinde Pay Bills sayfasina gidin
        Driver.getDriver().findElement(By.xpath("//strong[text()='Online Banking']")).click();
        Driver.getDriver().findElement(By.xpath("//*[ @id='pay_bills_link']")).click();

        // “Purchase Foreign Currency” tusuna basin
        Driver.getDriver().findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

        // “Currency” drop down menusunden Eurozone (Euro)’u secin
        WebElement element = Driver.getDriver().findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(element);
        select.selectByValue("EUR");

        // soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(select.getFirstSelectedOption().getText(), "Eurozone (euro)");
        softAssert.assertAll();

        // soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin: "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)", "China
        // (yuan)", "Denmark (krone)", "Eurozone (euro)", "Great Britain (pound)", "Hong Kong (dollar)", "Japan (yen)", "Mexico (peso)", "Norway (krone)", "New Zealand (dollar)",
        // "Sweden (krona)", "Singapore (dollar)", "Thailand (baht)"
        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//select[@id='pc_currency']"));
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

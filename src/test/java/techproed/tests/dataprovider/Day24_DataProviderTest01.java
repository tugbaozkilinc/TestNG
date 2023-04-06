package techproed.tests.dataprovider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.GoogleHomePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day24_DataProviderTest01 {

    //Data Provider Nedir?
    //Veri deposudur. Bir cok veriyi Test Case lere loop kullanmadan aktarmak icin kullanilir
    //Data provider 2D(2 boyutlu) Object return eder
    //Data provider TestNG den gelen bir ozelliktir
    //Data Provider ne icin kullanilir?
    //Data provider DDT(Data Driven Testing) icin kullanilir. Birden fazla datayi test caselerde kullanmak icin kullanilir
    //Data Provider i nasil kullanirsin?
    //@DataProvider annotation ile veri havuzu olusturulur.
    //@Test method larina bu data havuzu dataProvider parametresi ile baglanir, data parametresi ile de veri akisi saglanir.
    //Data provider da 2 tane parametre vardir:
    //name : method ismini overwrite yapmak icin, yani farkli bir isim ile data provider i cagirmak icin kullanilir.
    //parallel : parallel test case ler olusturmak icin kullanilir.

    @DataProvider(name = "smoke_test_data")
    public Object[][] products() {
        Object[][] productList = {
                {"tesla"},
                {"bmw"},
                {"mercedes"},
                {"honda"},
                {"toyota"},
                {"volvo"}
        };
        return productList;
    }

    @Test(dataProvider = "smoke_test_data")
    public void searchTest(String data) {
        System.out.println(data);
    }

    //Google a git
    //Datalari arama kutusuna gir ve enter a bas
    //Sayfa title inin gonderilen data isimlerini icerdigini test et.
    //Driver i kapat

    GoogleHomePage googleHomePage;
    @Test(dataProvider = "smoke_test_data")
    public void googleSearchTest(String data) {
        Driver.getDriver().get(ConfigReader.getProperty("google_url"));
        googleHomePage = new GoogleHomePage();
        googleHomePage.searchBox.sendKeys(data, Keys.ENTER);
        Assert.assertTrue(Driver.getDriver().getTitle().contains(data));
        Driver.closeDriver();
    }

}

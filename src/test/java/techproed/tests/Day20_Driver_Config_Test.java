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

    //Bir sirkette test framework’u olusturdugumuzda kullanici adi, sifresi, gidilecek web adresi gibi test datalari tum testler icin gecerlidir.
    //Daha kullanisli bir Framework olusturmak icin temel hedefimiz, tekrar tekrar yaptigimiz islemleri ve testlerimizde kullandigimiz Test Data’larini onceden
    //hazirladigimiz dosyalarda tutmaktir.
    //POM çok popüler bir Framework Design Pattern‘dir. Test suitlerimizde çok fazla testimiz olduğunda, test caseleri ve kodları korumak daha karmaşık hale gelir.
    //Bu nedenle, sürdürülebilir(maintainable), yeniden kullanılabilir(reusable), daha hızlı(faster), anlaşılabilir(understandable) daha iyi bir framework dizaynina ihtiyacımız vardir.

}

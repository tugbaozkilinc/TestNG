package techproed.tests;

import org.testng.Assert;
import org.testng.Reporter;
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

    //Note: Selenium'da ChromeOptions isminde bir class var. Bu classtan obje oluşturarak çeşitli methodlarla chrome ayarlarını yapabiliyoruz örneğin .addArguments("--start-maximized");
    //methodu chromu tam ekran başlatıyor .addExtension() methodu ile uzantı ekleyebiliyoruz vs. .setHeadless(true) methodu ise isminden anlaşılacağı üzere başsız, yani chrome browser
    //hiç açılmadan test yürütülüyor, test yürütülürken biz herhangi bir arayüz görmüyoruz ve neticeyi console'da görebiliyoruz. Bunun sebebi ise testler headless bir ortamda daha hızlı oluyor.
    //pageLoadTimeout(), selenium'un, bir sayfanın yüklenmesi için bekleyeceği süreyi tanımlar. Bence implicitlyWait'den farkı şu olabilir. Bazen sayfa yüklenmiş olsa dahi
    //sitenin içindeki herhangi bir element yüklenmemiş olabiliyor. Bu durumda implictWait hata vermeden önce her halükalarda 15(belirtilen sure) saniye şansımızı denememize olanak sağlıyor.

}

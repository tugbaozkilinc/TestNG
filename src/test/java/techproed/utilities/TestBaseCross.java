package techproed.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class TestBaseCross {

    protected WebDriver driver;
    @Parameters("browser") //@Parameters gelen parametreyi kullanmak icin eklenir.
    @BeforeClass
    public void setup(@Optional String browser) { //Burda @Optional yazma sebebimiz setup methoduna parameter gelmese de calismasini istememiz.
        driver = CrossDriver.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}

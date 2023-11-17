package techproed.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class Driver {

    private Driver(){} //Bu class ın Singleton pattern ile kullanıldığının bir işaretidir. (Singleton pattern bir class ın yalnızca bir örneğinin oluşturulmasını ve bu tek örneğin tüm uygulama boyunca kullanılmasını sağlar.)

    private static WebDriver driver;
    public static WebDriver getDriver(){ //getDriver() is used to instantiate the driver object
        if (driver==null){
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "chrome-headless":
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        return driver;
    }

    public static void closeDriver(){ //closeDriver() is used to close the driver
        if (driver!=null){
            driver.quit(); //if driver is already being used(pointing an object) then quit the driver
            driver=null;
        }
    }

}

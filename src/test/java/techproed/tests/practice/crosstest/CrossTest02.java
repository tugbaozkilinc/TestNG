package techproed.tests.practice.crosstest;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.TestBaseCross;

public class CrossTest02 extends TestBaseCross {

    @Test
    public void test01() {
        driver.get(ConfigReader.getProperty("amazon_url"));
    }

}

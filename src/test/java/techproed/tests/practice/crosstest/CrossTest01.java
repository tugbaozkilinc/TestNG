package techproed.tests.practice.crosstest;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.TestBaseCross;

public class CrossTest01 extends TestBaseCross {

    @Test
    public void test01() {
        driver.get(ConfigReader.getProperty("youtube_url"));
    }

}

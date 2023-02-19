package techproed.tests.listeners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class Day27_ListenersTest2 {

    @Test
    public void test1() {
        System.out.println("PASS");
        Assert.assertTrue(true);
    }

    @Test
    public void test2() {
        System.out.println("FAIL");
        Assert.assertTrue(false);
    }

    @Test
    public void test3() {
        System.out.println("SKIP");
        throw new SkipException("Skip the method");
    }

    @Test
    public void test4() {
        System.out.println("EXCEPTION");
        Driver.getDriver().get("https://www.techproeducation.com");
        Driver.getDriver().findElement(By.name("newYork"));
    }

}

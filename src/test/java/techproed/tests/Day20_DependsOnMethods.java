package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day20_DependsOnMethods {

    // TestNG de tum test method lari birbirlerinden bagimsiz olarak calisirlar. Eger method lari bagimli hale getirmek istersek dependsOnMethods parametresi kullanilir.

    @Test
    public void homeTest() {
        System.out.println("Home Test");
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = "homeTest")
    public void searchTest() {
        System.out.println("Search test");
    }

    @Test
    public void paymentTest() {
        System.out.println("Payment Test");
    }

}

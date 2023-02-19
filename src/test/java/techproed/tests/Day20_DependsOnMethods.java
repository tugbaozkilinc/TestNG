package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day20_DependsOnMethods {

    //TestNG de tum test method lari birbirlerinden bagimsiz olarak calisirlar. Eger method lari birbirine bagimli hale getirmek istersek dependsOnMethods parametresi kullanilir.

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

    //Test datalari nerden gelir?
    //BA
    //Test Lead
    //Tech Lead/Team Lead/Dev Lead
    //Manual Tester
    //Developer
    //Test datalarini test caselerde nasıl kullanırsın?
    //Dynamic olarak alirim. Datalar dışardaki bazı dosyalardan gelir :
    //External Files
    //Config.properties
    //Excel
    //Json
    //Xml
    //Database
    //API
    //Faker

}

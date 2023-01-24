package techproed.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day20_SoftAssertion {

    // TestNG ile iki cesit Asertion yapmak mumkundur;
    // 1. Hard Assert: Junit’te kullandigimiz  sekilde Assert Class’indan  method’lar kullanarak yapmak. (stops execution).
    // 2. Soft Assert(Verification): Junit’te olmayan, TestNG’ye ozel olarak kullanabilecegimiz SoftAssert Class’indan method’lar kullanarak yapmak. (don't stops execution)

    @Test
    public void testName() {
        SoftAssert softAssert = new SoftAssert();

        System.out.println("Satir 16");
        softAssert.assertEquals(2, 5); // fail
        System.out.println("Satir 18");
        softAssert.assertTrue("JAVA".contains("U")); // fail
        System.out.println("Satir 20");
        softAssert.assertTrue(true); // pass
        System.out.println("Satir 22");
        softAssert.assertAll(); // Pass ya da Fail olarak assertion lari isaretler
    }

}

package techproed.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day20_SoftAssertion {

    //TestNG ile iki cesit Asertion yapmak mumkundur;
    //1. Hard Assert: Junit’te kullandigimiz sekilde Assert Class’indan method’lar kullanarak yapmak. (stops execution).
    //2. Soft Assert(Verification): Junit’te olmayan, TestNG’ye ozel olarak kullanabilecegimiz SoftAssert Class’indan method’lar kullanarak yapmak. (don't stop execution)

    @Test
    public void testName() {
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Satir 15");
        softAssert.assertEquals(2, 5); //fail
        System.out.println("Satir 17");
        softAssert.assertTrue("JAVA".contains("U")); //fail
        System.out.println("Satir 19");
        softAssert.assertTrue(true); //pass
        System.out.println("Satir 21");
        softAssert.assertAll(); //Pass ya da Fail olarak assertion in durumunu raporlar. Bunu kullanmazsan sadece pass olanlari gorursun, fail olanlari goremezsin.
        System.out.println("Satir 15");
    }

    //Singleton Pattern (Tekli Kullanim)
    //Herhangi bir Java classindan obje kullanimini sinirlayabiliriz. Buna Singleton pattern(tekli kullanim) denir.
    //Singleton pattern, class’ı tek bir instance ile kısıtlayan bir software dizayn kalıbıdır.
    //Driver Class’i singleton pattern’e uygun dizayn ederek tum projede farkli driver lar uretilmesinin onune geceriz.
    //Eger assertion’lardan FAILED olan varsa raporlama(raporlamayı assertAll() ile yapıyoruz) yapilan satirdan sonrasini calistirmaz.

}

package techproed.tests;

import org.testng.annotations.*;

public class Day19_TestNGAnnotations {

    //TestNG Junit’in gelismis versiyonudur. Açık Kaynak kodludur. TestNG bir test kütüphanesidir. TestNG sadece JAVA ile calisir
    //Tester’lar TestNG’yi etkili bir framework tasarlamak ve test case’leri TestNG annotation’ları ile organize etmek için kullanırlar.
    //Yazılan test case’lerin paralel olarak çalıştırılmasına, birden fazla browser kullanilmasina imkan tanir. Paralel ve Cross-Browser Test yapmamiza imkan tanir

    //@Test : test case olusturmak icin kullanilir.
    //@Before ve @After: 5 Before 5 After annotations var;
    //suite > test > groups > class > method
    //@BeforeSuite : her bir test suite ten once 1 sefer calisir
    //@AfterSuite : Her bir test suite'den sonra 1 sefer calisir
    //@BeforeTest : Her bir Test'den once(TEST CASE ILE KARISTIRILMAMALI) 1 sefer calisir
    //@AfterTest : Her bir Test'den sonra(TEST CASE ILE KARISTIRILMAMALI) 1 sefer calisir
    //@BeforeClass : Her bir class'dan once 1 sefer calisir
    //@AfterClass : Her bir class'dan sonra 1 sefer calisir
    //@BeforeMethod : her bir @Test annotationdan once tek sefer calisir. JUnitdeki karsiligi @Before
    //@AfterMethod : her bir @Test annotationdan sonra tek sefer calisir. JUnitdeki karsiligi @After
    //@Test(enabled = false) : @Test case leri kullanima kapatmak icin kullanilir
    //@Ignore (@Test @Ignore): @Test caseleri atlamak(skip,ignore) icin kullanilir
    //@Test(priority = 1) : Test caseleri onceliklendirmek icin kullanilir
    //Not: default priority nin degeri 0 a esittir
    //@Test = @Test(priority = 0)

    //TestNG(default) olarak @Test methodlarıni alfabetik sıraya göre run eder.(Yukaridan asagiya degil!)(amazonTest(), buyTest(), youtubeTest()...)

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @BeforeGroups //Calismasi icin parametre verilmeli.
    public void beforeGroups(){
        System.out.println("Before Groups");
    }

    @BeforeClass //static
    public static void beforeClass(){
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }

    @AfterClass //static
    public static void afterClass(){
        System.out.println("After Class");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }

    @Test(priority = 1, groups = "regression-tests")
    public void test7(){
        System.out.println("Test 7");
    }

    @Test @Ignore
    public void test2(){
        System.out.println("Test 2");
    }

    @Test(enabled = false)
    public void test3(){
        System.out.println("Test 3");
    }

    @Test(priority = 4, groups = "regression-tests")
    public void test4(){
        System.out.println("Test 4");
    }

    @Test(priority = 2)
    public void test5(){
        System.out.println("Test 5");
    }

    @Test(priority = -5)
    public void test6(){
        System.out.println("Test 6");
    }

}

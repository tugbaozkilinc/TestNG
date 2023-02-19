package techproed.tests.homework;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Homework06 {

    //Name:
    //US101201_Negative_Login
    //Description:
    //Geçerli giriş yapmadan rezervasyon yapamamalı
    //Acceptance Criteria:
    //Kullanici arac bilgilerini girip CONTINUE RESERVATION butonuna tikladiginda Ve giris yapilmadiginda
    //Hata mesaji almali : Please first login
    //Giris yapildiginda hata mesaji alınmamalı

    BlueRentalHomePage blueRentalHomePage;
    @Test
    public void US101201_Negative_Login() {
        Driver.getDriver().get(ConfigReader.getProperty("blue_rental_car_url"));
        blueRentalHomePage = new BlueRentalHomePage();
        Faker faker = new Faker();
        Select car = new Select(blueRentalHomePage.selectACarBox);
        car.selectByVisibleText("Ford Fiesta");
        LocalDate date = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hhmmaa");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 2);
        blueRentalHomePage.pickUpBox.sendKeys(faker.address().cityName());
        blueRentalHomePage.dropOffBox.sendKeys(faker.address().cityName());
        blueRentalHomePage.pickUpDateBox.sendKeys(dateTimeFormatter.format(date));
        blueRentalHomePage.pickUpTimeBox.sendKeys(simpleDateFormat.format(calendar.getTime()));
        blueRentalHomePage.dropOffDateBox.sendKeys(dateTimeFormatter.format(date.plusWeeks(1)));
        blueRentalHomePage.dropOffTimeBox.sendKeys(simpleDateFormat.format(calendar.getTime()));
        blueRentalHomePage.continueReservationButton.click();
        ReusableMethods.waitFor(1);
    }

}

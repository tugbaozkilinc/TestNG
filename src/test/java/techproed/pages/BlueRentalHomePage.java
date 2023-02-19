package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class BlueRentalHomePage {

    public BlueRentalHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(partialLinkText = "Login")
    public WebElement loginButton;

    @FindBy(id = "dropdown-basic-button")
    public WebElement userId;

    @FindBy(xpath = "//select[@name='car']")
    public WebElement selectACarBox;

    @FindBy(name = "pickUpLocation")
    public WebElement pickUpBox;

    @FindBy(name = "dropOfLocation")
    public WebElement dropOffBox;

    @FindBy(name = "pickUpDate")
    public WebElement pickUpDateBox;

    @FindBy(name = "pickUpTime")
    public WebElement pickUpTimeBox;

    @FindBy(name = "dropOffDate")
    public WebElement dropOffDateBox;

    @FindBy(name = "dropOffTime")
    public WebElement dropOffTimeBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement continueReservationButton;

    @FindBy(linkText = "Logout")
    public WebElement logoutButton;

    @FindBy(xpath = "//button[.='OK']")
    public WebElement okButton;

}

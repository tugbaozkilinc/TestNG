package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class FacebookLoginPage {

    public FacebookLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "email")
    public WebElement emailBox;

    @FindBy(name = "pass")
    public WebElement passwordBox;

    @FindBy(name = "login")
    public WebElement loginButton;

    @FindBy(xpath = "//*[text()='Find your account and log in.']")
    public WebElement firstErrorMessage;

}

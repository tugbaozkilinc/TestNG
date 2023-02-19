package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class ZeroWebAppSecurityHomePage {

    public ZeroWebAppSecurityHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='signin_button']")
    public WebElement signInButton;

    @FindBy(xpath = "//strong[text()='Online Banking']")
    public WebElement onlineBankingButton;

}

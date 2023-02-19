package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

import java.util.List;

public class ZeroWebAppSecurityMakePaymentsPage {

    public ZeroWebAppSecurityMakePaymentsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrencyButton;

    @FindBy(xpath = "//select[@id='pc_currency']")
    public WebElement currencyDropdown;

    @FindBy(xpath = "//select[@id='pc_currency']")
    public List<WebElement> currencyDropdownBox;

}

package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class ZeroWebAppSecurityPayBillsPage {

    public ZeroWebAppSecurityPayBillsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[ @id='pay_bills_link']")
    public WebElement payBillsButton;

}

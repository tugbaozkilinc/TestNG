package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class YoutubeHomePage {

    public YoutubeHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//*[@id='logo-icon'])[1]")
    public WebElement youtubeLogo;

    @FindBy(xpath = "//input[@id='search']")
    public WebElement searchBox;

}

package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class AmazonHomePage {

    public AmazonHomePage() { PageFactory.initElements(Driver.getDriver(), this); }

    //PageFactory.initElements() metodu, AmazonHomePage sınıfı içinde tanımlanan WebElement'lerin başlatılmasını sağlar. Bu metod, belirtilen sürücüyü kullanarak, sayfa öğelerini bulmak ve başlatmak için gerekli olan sorguları(queries) çalıştırır.

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(xpath = "(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]")
    public WebElement resultWriting;

    @FindBy(xpath = "(//*[@class='s-image'])[1]")
    public WebElement firstProduct;

}

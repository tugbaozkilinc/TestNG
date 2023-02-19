package techproed.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class ReusableMethods {

    public static void takeScreenshotOfPage(String name) throws IOException {
        //naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        //TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE); //image
        //full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + date + name + ".png";
        File finalDestination = new File(target);
        //save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
    }

    public void takeScreenshotOfElement(WebElement element) throws IOException {
        File image = element.getScreenshotAs(OutputType.FILE);
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + currentTime + ".png";
        FileUtils.copyFile(image, new File(path));
    }

    //Switching Window
    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return; //It's used to get out of the method
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    public static void switchToWindow(int windowNumber){
        List<String> list = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(list.get(windowNumber));
    }

    //Return a list of String given a list of Web Element
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elementTexts = new ArrayList<>();
        for (WebElement el : list) {
            if (!el.getText().isEmpty()) {
                elementTexts.add(el.getText());
            }
        }
        return elementTexts;
    }

    //Returns the text of the element given an element locator
    public static List<String> getElementsText(By locator) {
        List<WebElement> elements = Driver.getDriver().findElements(locator);
        List<String> elementTexts = new ArrayList<>();
        for (WebElement el : elements) {
            if (!el.getText().isEmpty()) {
                elementTexts.add(el.getText());
            }
        }
        return elementTexts;
    }

    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Explicitly Wait
    public static WebElement visibilityOf(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement visibilityOfElementLocated(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement elementToBeClickable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement elementToBeClickable(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }

    //This can be used when a new page opens
    public static void waitForPageToLoad(long timeout) { //------------------------------------------------------------------------------------
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println("Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }

    //Fluent Wait
    public static WebElement fluentWait(final WebElement webElement, int timeout) { //------------------------------------------------------------
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(3)) //Wait 3 second each time
                .pollingEvery(Duration.ofSeconds(1)) //Check for the element every 1 second
                .ignoring(NoSuchMethodException.class);
        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return webElement;
            }
        });
    }

    public static void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }
    }

    public static WebElement selectRandomTextFromDropdown(Select select) {
        Random random = new Random();
        List<WebElement> webElementList = select.getOptions();
        int optionIndex = 1 + random.nextInt(webElementList.size()-1);
        select.selectByIndex(optionIndex);
        return select.getFirstSelectedOption();
    }

    public static void verifyElementDisplayed(By by) { //---------------------------------------------------------------------------
        try {
            assertTrue("Element not visible: " + by, Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.fail("Element not found: " + by);
        }
    }

    public static void verifyElementNotDisplayed(By by) { //----------------------------------------------------------------------------
        try {
            assertFalse("Element should not be visible: " + by, Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public static void verifyElementNotDisplayed(WebElement element) { //----------------------------------------------------------------
        try {
            assertFalse("Element should not be visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public static void verifyElementDisplayed(WebElement element) { //---------------------------------------------------------------
        try {
            assertTrue("Element not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.fail("Element not found: " + element);
        }
    }

    public void scrollIntoViewJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollEndJS(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollTopJS(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }

    public void clickByJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public void typeWithJS(WebElement element, String text){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('value', '" + text + "');", element);
    }

    public void getValueByJS(String idOfElement) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String text = js.executeScript("return document.getElementById('" + idOfElement + "').value").toString();
        System.out.println("The value in the box is: " + text);
    }

    public static void rightClickOnElementActions(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(element).perform();
    }

    public static void doubleClickOnElementActions(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }

    public static void hoverOverOnElementActions(WebElement element) {
        new Actions(Driver.getDriver()).moveToElement(element).perform();
    }

    public static void scrollDownActions() {
        new Actions(Driver.getDriver()).sendKeys(Keys.PAGE_DOWN).perform();
    }

    public static void scrollUpActions() {
        new Actions(Driver.getDriver()).sendKeys(Keys.PAGE_UP).perform();
    }

    public static void scrollRightActions(){
        new Actions(Driver.getDriver()).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).build().perform();
    }

    public static void scrollLeftActions(){
        new Actions(Driver.getDriver()).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).build().perform();
    }

    public static void dragAndDropActions(WebElement source, WebElement target) {
        new Actions(Driver.getDriver()).dragAndDrop(source, target).perform();
    }

    public static void dragAndDropActions(WebElement source, int x, int y) {
        new Actions(Driver.getDriver()).dragAndDropBy(source, x, y).perform();
    }

}

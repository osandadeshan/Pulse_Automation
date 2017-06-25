package pages;

import stepImpl.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Osanda on 4/26/2017.
 */


public abstract class BasePage {

    protected static String URL = System.getenv("APP_ENDPOINT");

    public void waitForElementClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(DriverFactory.driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(DriverFactory.driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void setTextAs(WebElement element, String text){
        waitForElementClickable(element);
        element.sendKeys(text);
    }

    public void waitSeconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds*1000);
    }

}

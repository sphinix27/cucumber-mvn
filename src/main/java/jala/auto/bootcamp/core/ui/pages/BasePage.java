package jala.auto.bootcamp.core.ui.pages;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * BasePage
 */
public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Wait<WebDriver> fluentWait;
    private int timeout = 20;
    private int fluentTimeout = 20;
    private int fluentInterval = 5;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, timeout);
        this.fluentWait = new FluentWait<WebDriver>(this.driver)
                .withTimeout(Duration.ofSeconds(fluentTimeout))
                .pollingEvery(Duration.ofSeconds(fluentInterval))
                .ignoring(NoSuchElementException.class);

        PageFactory.initElements(this.driver, this);
    }

    protected void sendKeys(WebElement webElement, String value) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(value);
    }

    protected void sendKeysFluent(By locator, String value) {
        WebElement element = fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
              return driver.findElement(locator);
            }
        });
        element.clear();
        element.sendKeys(value);
    }

    protected void click(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    protected void clear(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
    }

    protected Boolean isDisplayed(By locator) {
        WebElement element = fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
              return driver.findElement(locator);
            }
        });
        return element.isDisplayed();
    }
}

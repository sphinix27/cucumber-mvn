package jala.auto.bootcamp.core.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * TrelloLoginPage
 */
public class TrelloLoginPage extends BasePage{

    @FindBy(name = "user")
    private WebElement usernameInput;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(css = ".show-when-password.hidden")
    private WebElement passwordDivHidden;

    @FindBy(className = "show-when-password")
    private WebElement passwordDiv;

    public TrelloLoginPage(WebDriver driver) {
        super(driver);
        driver.get("https://trello.com/login");
    }

    public void setUsernameInput(String username) {
        sendKeys(usernameInput, username);
    }

    public void login(String username) {
        sendKeys(usernameInput, username);
        click(loginButton);
    }

    public void clearUsernameInput() {
        clear(usernameInput);
    }

    public Boolean passwordIsVisible() {
        return isDisplayed(By.name("password"));
    }

    public Boolean passwordIsHidden() {
        return wait.until(ExpectedConditions.invisibilityOf(passwordDivHidden));
    }
}

package jala.auto.bootcamp.core.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * TrelloLoginPage
 */
public class TrelloLoginPage extends BasePage{

    @FindBy(name = "user")
    private WebElement usernameInput;

    @FindBy(id = "login")
    private WebElement loginButton;

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
}

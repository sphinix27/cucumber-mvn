package jala.auto.bootcamp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jala.auto.bootcamp.core.ui.pages.TrelloLoginPage;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;
/**
 * UISteps
 */
public class UISteps {

    private TrelloLoginPage loginPage;
    private WebDriver driver;

    @Given("user is in login page")
    public void userIsInLoginPage() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new TrelloLoginPage(driver);
    }

    @When("user enter username")
    public void userEnterUsername() throws InterruptedException {
        loginPage.setUsernameInput("sphinix27");
        // driver.manage().wait(5);
        // Thread.sleep(3000);
    }

    @When("user deletes username")
    public void userDeletesUsername() {
        loginPage.clearUsernameInput();
    }

    @Then("password should be visible")
    public void passwordInputIsVisible() {
        assertThat(loginPage.passwordIsVisible()).isTrue();
    }

    @Then("password should not be visible")
    public void passwordInputIsNotVisible() {
        assertThat(loginPage.passwordIsHidden()).isTrue();
    }
}

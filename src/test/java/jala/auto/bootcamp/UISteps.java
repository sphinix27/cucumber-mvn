package jala.auto.bootcamp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jala.auto.bootcamp.core.ui.pages.TrelloLoginPage;

import static org.assertj.core.api.Assertions.assertThat;
/**
 * UISteps
 */
public class UISteps {

    private TrelloLoginPage loginPage;

    @Given("user is in login page")
    public void userIsInLoginPage() {
        WebDriver driver = new ChromeDriver();
        loginPage = new TrelloLoginPage(driver);
    }

    @When("user enter username")
    public void userEnterUsername() throws InterruptedException {
        loginPage.setUsernameInput("sphinix27");
        Thread.sleep(3000);
    }

    @When("user deletes username")
    public void userDeletesUsername() {
        loginPage.clearUsernameInput();
    }

    @Then("password should be visible")
    public void passwordInputIsVisible() {
        assertThat(loginPage.passwordIsVisible()).isTrue();
    }
}

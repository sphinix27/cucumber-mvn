package jala.auto.bootcamp;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.response.Response;
import jala.auto.bootcamp.core.api.Request;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * ApiSteps
 */
public class ApiSteps {

    private String endpoint;
    private Response response;
    private Helper helper;

    public ApiSteps(Helper helper) {
        this.helper = helper;
    }

    @Given("the endpoint {string}")
    public void the_endpoint(String endpoint) {
        if (endpoint.contains("{boardId}")) {
            this.endpoint = endpoint.replace("{boardId}", this.helper.getBoardId());
        } else {
            this.endpoint = endpoint;
        }
    }

    @When("method {word}")
    public void method_GET(String method) {
        if ("GET".equals(method)) {
            this.response = Request.get(this.endpoint);
        } else {
            this.response = Request.delete(this.endpoint);
        }
    }

    @Then("status code {int}")
    public void status_code(Integer statusCode) {
        assertThat(this.response.statusCode()).isEqualTo(statusCode);
    }
}

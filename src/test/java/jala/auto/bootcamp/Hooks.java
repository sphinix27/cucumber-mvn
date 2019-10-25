package jala.auto.bootcamp;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import jala.auto.bootcamp.core.api.Request;

/**
 * Hooks
 */
public class Hooks {

    private Helper helper;

    public Hooks(Helper helper) {
        this.helper = helper;
    }

    @Before("@CreateBoard")
    public void createBoard() {
        Response response = Request.post("/boards", "{\"name\": \"Example\"}");
        this.helper.setBoardId(response.jsonPath().get("id"));
    }

    @After("@DeleteBoard")
    public void DeleteBoard() {
        String endpoint = "/boards/".concat(this.helper.getBoardId());
        Request.delete(endpoint);
    }
}

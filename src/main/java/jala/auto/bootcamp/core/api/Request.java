package jala.auto.bootcamp.core.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jala.auto.bootcamp.core.utils.Env;

import static io.restassured.RestAssured.given;

/**
 * Request
 */
public final class Request {

    private static RequestSpecification requestSpecification = new RequestSpecBuilder()
        .setBaseUri(Env.getInstance().getApiUrl())
        .addQueryParam("key", Env.getInstance().getApiKey())
        .addQueryParam("token", Env.getInstance().getApiToken())
        .build();


    private Request() {

    }

    public static Response  get(final String endpoint) {
        return given()
                .spec(requestSpecification)
                .when()
                .get(endpoint);
    }

    public static Response post(final String endpoint, final String body) {
        return given()
                .spec(requestSpecification)
                .contentType(ContentType.JSON)
                .when()
                .body(body)
                .post(endpoint);
    }

    public static Response delete(final String endpoint) {
        return given()
                .spec(requestSpecification)
                .when()
                .delete(endpoint);
    }
}

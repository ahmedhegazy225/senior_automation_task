package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class APIClient {
    public APIClient() {
        RestAssured.baseURI = "https://pay2.foodics.dev";
    }

    public Response post(String endpoint, String body) {
        return given().header("Content-Type", "application/json").body(body).post(endpoint);
    }

    public Response get(String endpoint, String token) {
        return given().header("Authorization", "Bearer " + token).get(endpoint);
    }
}

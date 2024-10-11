package api;

import io.restassured.response.Response;

public class FoodicsLoginAPI extends APIClient {

    // Method to return only the token from login response
    public String login(String email, String password) {
        String body = "{ \"email\": \"" + email + "\", \"password\": \"" + password + "\" }";
        Response response = post("/cp_internal/login", body);
        return response.jsonPath().getString("token");
    }

    // Method to return full response for login, useful for invalid login tests
    public Response loginWithResponse(String email, String password) {
        String body = "{ \"email\": \"" + email + "\", \"password\": \"" + password + "\" }";
        return post("/cp_internal/login", body);
    }
}

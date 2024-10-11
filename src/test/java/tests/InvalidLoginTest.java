package tests;

import api.FoodicsLoginAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTest {

    @Test
    public void testInvalidLogin() {
        FoodicsLoginAPI loginAPI = new FoodicsLoginAPI();

        // Call login API with invalid credentials
        Response response = loginAPI.loginWithResponse("invalid@foodics.com", "wrongpassword");

        // Verify that the status code is 401 or 400 (depending on API behavior)
        Assert.assertTrue(response.getStatusCode() == 401 || response.getStatusCode() == 400, "Expected 401 or 400 for invalid login");

        // Verify the error message
        String errorMessage = response.jsonPath().getString("error");
        Assert.assertTrue(errorMessage.contains("Invalid email or password"), "Error message should indicate invalid credentials");
    }
}

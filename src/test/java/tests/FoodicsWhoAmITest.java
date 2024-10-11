package tests;

import api.FoodicsLoginAPI;
import api.FoodicsWhoAmIAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FoodicsWhoAmITest {

    @Test
    public void testWhoAmIAPI() {
        // Step 1: Login and get token
        FoodicsLoginAPI loginAPI = new FoodicsLoginAPI();
        String token = loginAPI.login("merchant@foodics.com", "123456");

        // Step 2: Verify the token is not null or empty
        Assert.assertNotNull(token, "Token should not be null");
        Assert.assertFalse(token.isEmpty(), "Token should not be empty");

        // Step 3: Call the WhoAmI API with the token
        FoodicsWhoAmIAPI whoAmIAPI = new FoodicsWhoAmIAPI();
        Response response = whoAmIAPI.getWhoAmI(token);

        // Step 4: Verify the response status code and check user details in the response
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200");
        String email = response.jsonPath().getString("email");
        Assert.assertEquals(email, "merchant@foodics.com", "Email should match the logged-in user");
    }
}

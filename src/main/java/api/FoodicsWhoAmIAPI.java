package api;

import io.restassured.response.Response;

public class FoodicsWhoAmIAPI extends APIClient {

    public Response getWhoAmI(String token) {
        return get("/cp_internal/whoami", token);
    }
}

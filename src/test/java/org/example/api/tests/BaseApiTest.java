package org.example.api.tests;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import org.example.api.model.Product;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.util.List;

import static org.example.utils.Constants.BASE_URL_API;

@RunWith(SerenityRunner.class)
public class BaseApiTest {
    protected Response get(String endpoint) {
        return SerenityRest.rest()
                .relaxedHTTPSValidation()
                .get(BASE_URL_API + endpoint);
    }

    protected void verifyStatus(Response response, int expectedCode) {
        Assert.assertEquals("Unexpected status code", expectedCode, response.statusCode());
    }

    protected List<Product> extractProducts(Response response) {
        JsonPath json = response.jsonPath();
        return json.getList("products", Product.class);
    }

    // Make the POST request and store the response
    protected Response post(String endpoint, Object body) {
        if (body != null) {
            return SerenityRest.rest()
                    .baseUri(BASE_URL_API)
                    .header("Content-Type", "application/json")
                    .body(body)
                    .post(endpoint);
        } else {
            return SerenityRest.rest()
                    .baseUri(BASE_URL_API)
                    .post(endpoint);
        }
    }
}

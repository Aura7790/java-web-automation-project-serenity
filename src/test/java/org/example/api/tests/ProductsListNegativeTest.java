package org.example.api.tests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class ProductsListNegativeTest extends BaseApiTest {

    @Test
    public void postToProductsListReturns405() {
        Response response = post("/productsList", null);

        int responseCode = response.jsonPath().getInt("responseCode");
        Assert.assertEquals(405, responseCode);

        String message = response.jsonPath().getString("message");
        Assert.assertEquals("This request method is not supported.", message);
    }
}


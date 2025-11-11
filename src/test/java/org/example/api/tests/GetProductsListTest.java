package org.example.api.tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.example.api.model.Product;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;


public class GetProductsListTest extends BaseApiTest {

    @Test
    public void checkProductsListReturnsSuccess() {
        // Step 1. Send GET request
        Response response = get("/productsList");
        // Step 2. Verify status code
        verifyStatus(response, 200);
        // Step 3. Parse JSON to Product list
        JsonPath json = response.jsonPath();
        // Get first product
        String firstProduct = json.getString("products[0]");
        System.out.println(firstProduct);
        // Get the list of products
        List<Product> products = extractProducts(response);
        // Step 4. Validate the list is not empty
        Assert.assertNotNull("Products list should not be null", products);
        Assert.assertFalse("Products list should not be empty", products.isEmpty());
        // Step 5. Validate first product has the expected fields
        Product first = products.get(0);
        Assert.assertNotNull("Product ID should not be null", first.getId());
        Assert.assertNotNull("Product name should not be null", first.getName());
        // Step 6. Log results for visibility
        System.out.println("Total products: " + products.size());
        products.stream().limit(5).forEach(p ->
                System.out.println("Product: " + p.getName() + " | Price: " + p.getPrice())
        );
        // Step 7. Log response if validation fails (Serenity report)
        response.then().log().ifValidationFails();

    }
}

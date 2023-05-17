package com.it_academy.test.onliner.api;

import com.google.common.collect.ImmutableMap;
import com.it_academy.onliner.rest_api.models.Product;
import com.it_academy.onliner.rest_api.service.SushiService;
import org.apache.commons.collections4.MapUtils;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class RestAssuredTest {
    @Test
    public void verifyProductsServiceValues(){
        List<Product> productList = new SushiService().getProducts();
        productList.stream().forEach(product -> {
            boolean b = product.getId() == null
                    && product.getFull_name() == null
                    && product.getKey() == null
                    && product.getName() == null;
            assertFalse(b);
        });
    }
    @Test
    public void verifyNamePrefix(){
        given()
                .headers(configureHeaders())
                .params(filterRoll())
                .when()
                .get("https://catalog.onliner.by/sdapi/catalog.api/search/sushivesla")
                .then()
                .statusCode(200)
                .body("products.name_prefix[0]", startsWith("Роллы"));
    }

    private Map<String, Object> configureHeaders(){
        return ImmutableMap.of("Host", "catalog.onliner.by");
    }
    private Map <String, Object> filterRoll(){
        return ImmutableMap.of("sushi_typ[0]", "roll");
    }
}

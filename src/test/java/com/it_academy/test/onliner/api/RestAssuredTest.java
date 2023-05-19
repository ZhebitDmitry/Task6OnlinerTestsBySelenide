package com.it_academy.test.onliner.api;

import com.it_academy.onliner.rest_api.models.Product;
import com.it_academy.onliner.rest_api.service.SushiService;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RestAssuredTest {
    @Test
    public void verifyProductsServiceValues() {
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
    public void checkContainsPrefixRoll() {
        List<String> prefixList = new SushiService().getNamePrefixWithFilter();
        assertTrue(prefixList
                .stream()
                .allMatch(prefix -> prefix.contains("Роллы")));
    }
}

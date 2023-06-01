package com.it_academy.test.onliner.api;

import com.it_academy.onliner.rest_api.models.Product;
import com.it_academy.onliner.rest_api.service.SushiService;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RestAssuredTest {
    protected static final Logger LOG = LoggerFactory.getLogger(RestAssuredTest.class);
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
        LOG.info("Все префиксы - "+prefixList);
        assertTrue(prefixList
                .stream()
                .allMatch(prefix -> prefix.contains("Роллы")));
    }
}

package com.it_academy.onliner.rest_api.service;

import com.google.common.collect.ImmutableMap;
import com.it_academy.onliner.rest_api.models.Product;

import java.util.List;
import java.util.Map;

import static com.it_academy.onliner.rest_api.endpoints.OnlinerEndpoints.getSushiVeslaEndpoint;
import static com.it_academy.onliner.rest_api.utils.getRequestUtils.makeGetRequestAndGetResponseBody;

public class SushiService {
    public List<Product> getProducts() {
        return makeGetRequestAndGetResponseBody(getSushiVeslaEndpoint(), configureHeaders(), null)
                .jsonPath()
                .getList("products", Product.class);
    }

    public List<String> getNamePrefixWithFilter() {
        return makeGetRequestAndGetResponseBody(getSushiVeslaEndpoint(), configureHeaders(), filterRoll())
                .jsonPath()
                .getList("products.name_prefix", String.class);
    }

    private Map<String, Object> configureHeaders() {
        return ImmutableMap.of("Host", "catalog.onliner.by");
    }

    private Map<String, Object> filterRoll() {
        return ImmutableMap.of("sushi_typ[0]", "roll");
    }
}

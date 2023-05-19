package com.it_academy.onliner.rest_api.endpoints;

import com.it_academy.onliner.pageobject.onliner.framework.PropertiesReader;

public class OnlinerEndpoints {
    public static String getSushiVeslaEndpoint() {
        return PropertiesReader.getEndpointProperties("ENDPOINT_SUSHIVESLA");
    }
}

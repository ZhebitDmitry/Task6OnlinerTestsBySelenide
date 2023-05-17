package com.it_academy.test.onliner.web;

import com.google.common.collect.ImmutableMap;
import com.it_academy.onliner.rest_api.models.Product;
import com.it_academy.onliner.pageobject.onliner.CatalogPage;
import com.it_academy.onliner.pageobject.onliner.MainPage;
import com.it_academy.onliner.pageobject.onliner.ProductsPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class OnlinerTest extends BaseTest {

    private final static String BASE_URL = "https://www.onliner.by/";
    private final static String URL = "https://catalog.onliner.by/sdapi/catalog.api/search/sushivesla";

    @Test
    public void testCheckSectionsOfCatalogIsExistsTest() {
        Assert.assertTrue(new MainPage(BASE_URL)
                .clickOnCatalog()
                .getCatalogSections()
                .stream()
                .allMatch(SelenideElement::exists));
    }

    @Test
    public void testCheckVerticalsListOfComputersAndNetworksTest() {
        new MainPage(BASE_URL)
                .clickOnCatalog()
                .clickOnCatalogSectionComputersAndNetworksSection()
                .getVerticalListOfComputersAndNetworks()
                .shouldBe(Condition.visible);
    }

    @Test
    public void testComputerComponentsHaveDescriptionAndPrice() {
        CatalogPage catalogPageWithComputersAndComponents = new MainPage(BASE_URL)
                .clickOnCatalog()
                .clickOnCatalogSectionComputersAndNetworksSection()
                .clickOnComputerComponentSection();

        int descriptionOfComponentsSize = catalogPageWithComputersAndComponents
                .getDescriptionOfComponents()
                .size();

        int titlesOfComponentsSize = catalogPageWithComputersAndComponents
                .getTitlesOfComponents()
                .size();

        int computerComponentsSize = catalogPageWithComputersAndComponents.getComputerComponents().size();

        Assert.assertTrue(computerComponentsSize == descriptionOfComponentsSize);
        Assert.assertTrue(computerComponentsSize == titlesOfComponentsSize);
    }

    @Test
    public void testMobilePhone() {
        ProductsPage mobilePhonesPage = new MainPage(BASE_URL).clickOnMobilePhones();
        mobilePhonesPage.getProductsList().shouldBe(Condition.visible);
        int productSectionQuantity = mobilePhonesPage.getProductSection().size();
        int titlesQuantity = mobilePhonesPage.getTitlesOfProducts().size();
        int descriptionQuantity = mobilePhonesPage.getDescriptionOfProducts().size();
        int ratingQuantity = mobilePhonesPage.getRatingOfProducts().size();
        int priceQuantity = mobilePhonesPage.getPricesOfProducts().size();
        int imageQuantity = mobilePhonesPage.getProductPictures().size();
        int checkBoxQuantity = mobilePhonesPage.getProductCheckBox().size();
        Assert.assertTrue(productSectionQuantity == titlesQuantity);
        Assert.assertTrue(titlesQuantity == descriptionQuantity);
        Assert.assertTrue(descriptionQuantity == ratingQuantity);
        Assert.assertTrue(ratingQuantity == priceQuantity);
        Assert.assertTrue(priceQuantity == imageQuantity);
        Assert.assertTrue(imageQuantity == checkBoxQuantity);
    }
    @Test
    public void testRest(){
        List<Product> productList = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL)
                .then().log().all()
                .extract().body().jsonPath().getList("products", Product.class);
        System.out.println(productList);
    }

//    @Test
//    public void testSushiRequest(){
//        ResponseBody responseBody = given()
//                .headers(configureHeaders())
//                .when()
//                .get(URL)
//                .then()
//                .statusCode(200)
//                .extract()
//                .response()
//                .getBody();
//        System.out.println(responseBody.asString());
//    }

}

package com.it_academy.test.onliner.web;

import com.it_academy.onliner.pageobject.onliner.CatalogPage;
import com.it_academy.onliner.pageobject.onliner.MainPage;
import com.it_academy.onliner.pageobject.onliner.ProductsPage;
import com.codeborne.selenide.SelenideElement;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;

public class OnlinerTest extends BaseTest {
    protected static final Logger LOG = LoggerFactory.getLogger(OnlinerTest.class);

    private final static String BASE_URL = "https://www.onliner.by/";
    @Test
    public void testCheckSectionsOfCatalogIsExistsTest() {
        LOG.info("Открыть раздел каталог, проверить присутствие секций \"Электроника\", \"Компьютеры и сети\"," +
                "\"Бытовая техника\", \"На каждый день\", \"Стройка и ремонт\"," +
                "\"Дом и сад\",\"Авто и мото\",\"Красота и спорт\",\"Детям и мамам\".");
        Assert.assertTrue(new MainPage(BASE_URL)
                .clickOnCatalog()
                .getCatalogSections()
                .stream()
                .allMatch(SelenideElement::exists));
    }

    @Test
    public void testCheckVerticalsListOfComputersAndNetworksTest() {
        LOG.info("Открыть секцию каталога \"Компьютеры и сети\". Убедиться, что появляется вертикальный список пунктов"+
                "секций");
        new MainPage(BASE_URL)
                .clickOnCatalog()
                .clickOnCatalogSectionComputersAndNetworksSection()
                .getVerticalListOfComputersAndNetworks()
                .shouldBe(visible);
    }

    @Test
    public void testComputerComponentsHaveDescriptionAndPrice() {
        LOG.info("Открыть пункт \"Комплектующие\". Проверить, что в появившемся списке комплектующих ВСЕ элементы \n" +
                "содержат название, количество товаров и минимальную цену.");
        CatalogPage catalogPageWithComputersAndComponents = new MainPage(BASE_URL)
                .clickOnCatalog()
                .clickOnCatalogSectionComputersAndNetworksSection()
                .clickOnComputerComponentSection();

        int descriptionOfComponentsSize = catalogPageWithComputersAndComponents
                .getDescriptionOfComponents()
                .size();
        LOG.info("Количество описаний - "+ descriptionOfComponentsSize);

        int titlesOfComponentsSize = catalogPageWithComputersAndComponents
                .getTitlesOfComponents()
                .size();
        LOG.info("Количество заголовков - "+ titlesOfComponentsSize);

        int computerComponentsSize = catalogPageWithComputersAndComponents
                .getComputerComponents()
                .size();
        LOG.info("Количество компонетов - "+ computerComponentsSize);


        Assert.assertTrue(computerComponentsSize == descriptionOfComponentsSize
                && computerComponentsSize == titlesOfComponentsSize);
    }

    @Test
    public void testMobilePhone() {
        LOG.info("Проверка наличия заголовков, описания, рейтингов, цен, иконок и чекбоксов у мобильных телефонов");
        ProductsPage mobilePhonesPage = new MainPage(BASE_URL).clickOnMobilePhones();
        mobilePhonesPage.getTitlesOfProducts().get(1).shouldBe(visible, Duration.ofSeconds(30));
        int productSectionQuantity = mobilePhonesPage.getProductSection().size();
        LOG.info("Количество продуктов - "+productSectionQuantity);
        int titlesQuantity = mobilePhonesPage.getTitlesOfProducts().size();
        LOG.info("Количество заголовков - "+titlesQuantity);
        int descriptionQuantity = mobilePhonesPage.getDescriptionOfProducts().size();
        LOG.info("Количество описаний - "+descriptionQuantity);
        int ratingQuantity = mobilePhonesPage.getRatingOfProducts().size();
        LOG.info("Количество рейтингов - "+ratingQuantity);
        int priceQuantity = mobilePhonesPage.getPricesOfProducts().size();
        LOG.info("Количество цен - "+priceQuantity);
        int imageQuantity = mobilePhonesPage.getProductPictures().size();
        LOG.info("Количество иконок - "+imageQuantity);
        int checkBoxQuantity = mobilePhonesPage.getProductCheckBox().size();
        LOG.info("Количество чекбоксов - "+checkBoxQuantity);
        Assert.assertTrue(productSectionQuantity == titlesQuantity &&
                titlesQuantity == descriptionQuantity &&
                descriptionQuantity == ratingQuantity &&
                ratingQuantity == priceQuantity &&
                priceQuantity == imageQuantity &&
                imageQuantity == checkBoxQuantity);
    }
}

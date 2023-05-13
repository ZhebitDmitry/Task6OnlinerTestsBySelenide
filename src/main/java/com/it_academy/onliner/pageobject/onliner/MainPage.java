package com.it_academy.onliner.pageobject.onliner;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement catalogButton =
            $x("//span[contains(text(), 'Каталог') and @class='b-main-navigation__text']");
    private final SelenideElement searchInCatalog = $x("//input[@class='fast-search__input']");
    private final SelenideElement mobilePhones = $x("//span//span[contains(text(), 'Мобильные телефоны')]");

    public MainPage(String url) {
        Selenide.open(url);
    }

    public CatalogPage clickOnCatalog() {
        catalogButton.click();
        return new CatalogPage();
    }

    public ProductsPage clickOnMobilePhones() {
        mobilePhones.click();
        return new ProductsPage();
    }
}
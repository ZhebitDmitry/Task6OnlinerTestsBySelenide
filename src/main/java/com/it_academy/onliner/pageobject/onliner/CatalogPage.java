package com.it_academy.onliner.pageobject.onliner;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CatalogPage {
    private final ElementsCollection catalogSections =
            $$x("//li[@class='catalog-navigation-classifier__item ']");
    private final ElementsCollection titlesOfComponents =
            $$x("//div[text()=\" Комплектующие \"]/following-sibling::*//a/span/span[@class='catalog-navigation-list__dropdown-title']");
    private final ElementsCollection descriptionOfComponents =
            $$x("//div[text()=\" Комплектующие \"]/following-sibling::*//a/span/span[@class='catalog-navigation-list__dropdown-description']");
    private final ElementsCollection computerComponents =
            $$x("//div[text()=\" Комплектующие \"]/following-sibling::*//a");
    private final SelenideElement computersAndNetworksSection = $x("//li[@data-id='2']");
    private final SelenideElement verticalListOfComputersAndNetworks =
            $x("//div[@data-id='2']//div[@class='catalog-navigation-list__aside-list']");
    private final SelenideElement computerComponentSection = $x("//div[text()=\" Комплектующие \"]");
    private final SelenideElement electronicsSection = $x("//span[contains(text(), 'Электроника')]");
    private final SelenideElement mobilePhones = $x("//div[contains(text(), 'Мобильные телефоны')]");

    public ElementsCollection getCatalogSections() {
        return catalogSections;
    }

    public ElementsCollection getComputerComponents() {
        return computerComponents;
    }

    public ElementsCollection getTitlesOfComponents() {
        return titlesOfComponents;
    }

    public ElementsCollection getDescriptionOfComponents() {
        return descriptionOfComponents;
    }

    public SelenideElement getVerticalListOfComputersAndNetworks() {
        return verticalListOfComputersAndNetworks;
    }

    public CatalogPage clickOnCatalogSectionComputersAndNetworksSection() {
        computersAndNetworksSection.click();
        return new CatalogPage();
    }

    public CatalogPage clickOnComputerComponentSection() {
        computerComponentSection.click();
        return new CatalogPage();
    }

    public CatalogPage clickOnElectronics() {
        electronicsSection.click();
        return new CatalogPage();
    }

    public ProductsPage clickOnMobilePhones() {
        mobilePhones.click();
        return new ProductsPage();
    }

}

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CatalogPage {
    private final ElementsCollection catalogSections =
            $$x("//li[@class='catalog-navigation-classifier__item ']");
    private final SelenideElement computersAndNetworksSection = $x("//li[@data-id='2']");
    private final SelenideElement verticalListOfComputersAndNetworks =
            $x("//div[@data-id='2']//div[@class='catalog-navigation-list__aside-list']");

    public ElementsCollection getCatalogSections() {
        return catalogSections;
    }

    public SelenideElement getVerticalListOfComputersAndNetworks() {
        return verticalListOfComputersAndNetworks;
    }

    public CatalogPage clickOnCatalogSectionComputersAndNetworksSection() {
        computersAndNetworksSection.click();
        return new CatalogPage();
    }

}

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ProductsPage {
    private final SelenideElement productsList =
            $x("//div[@class='js-schema-results schema-grid__center-column']");
    private final ElementsCollection productSection = $$x("//div[@class='schema-product__group']");
    private final ElementsCollection titlesOfProducts =
            $$x("//span[@data-bind='html: product.extended_name || product.full_name']");
    private final ElementsCollection descriptionOfProducts =
            $$x("//span[@data-bind='html: product.description']");
    private final ElementsCollection ratingOfProducts = $$x("//div[@class='schema-product__rating-group']");
    private final ElementsCollection pricesOfProducts =
            $$x("//div[@class='schema-product schema-product_narrow-sizes']/div/div[@class='schema-product__part schema-product__part_3']");
    private final ElementsCollection productPictures =
            $$x("//div[@class='schema-product schema-product_narrow-sizes']/div[@class='schema-product__part schema-product__part_1']");
    private final ElementsCollection productCheckBox =
            $$x("//div[@class='schema-product schema-product_narrow-sizes']/div[@class='schema-product__part schema-product__part_1']/div[@class='schema-product__compare']");
    private final ElementsCollection allCheckBox = $$x("//span[@class='i-checkbox i-checkbox_yellow']");

    public SelenideElement getProductsList() {
        return productsList;
    }

    public ElementsCollection getProductSection() {
        return productSection;
    }

    public ElementsCollection getTitlesOfProducts() {
        return titlesOfProducts;
    }

    public ElementsCollection getDescriptionOfProducts() {
        return descriptionOfProducts;
    }

    public ElementsCollection getRatingOfProducts() {
        return ratingOfProducts;
    }

    public ElementsCollection getPricesOfProducts() {
        return pricesOfProducts;
    }

    public ElementsCollection getProductPictures() {
        return productPictures;
    }

    public ElementsCollection getProductCheckBox() {
        return productCheckBox;
    }

    public ElementsCollection getAllCheckBox() {
        return allCheckBox;
    }
}

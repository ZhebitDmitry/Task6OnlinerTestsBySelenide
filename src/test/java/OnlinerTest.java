import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.Test;


public class OnlinerTest extends BaseTest {

    private final static String BASE_URL = "https://www.onliner.by/";

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
        Assert.assertTrue(new MainPage(BASE_URL)
                .clickOnCatalog()
                .clickOnCatalogSectionComputersAndNetworksSection()
                .getVerticalListOfComputersAndNetworks()
                .shouldBe(Condition.visible)
                .isDisplayed());
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
        System.out.println(descriptionOfComponentsSize);

        int titlesOfComponentsSize = catalogPageWithComputersAndComponents
                .getTitlesOfComponents()
                .size();
        System.out.println(titlesOfComponentsSize);

        int computerComponentsSize = catalogPageWithComputersAndComponents.getComputerComponents().size();
        System.out.println(computerComponentsSize);

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
}

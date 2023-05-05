import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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
    public void testComputerComponentsHaveDescriptionAndPrice(){
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

        Assert.assertTrue(computerComponentsSize==descriptionOfComponentsSize);
        Assert.assertTrue(computerComponentsSize==titlesOfComponentsSize);
    }
}

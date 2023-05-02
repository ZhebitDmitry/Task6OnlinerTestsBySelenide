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
}

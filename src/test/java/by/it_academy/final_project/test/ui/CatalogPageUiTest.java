package by.it_academy.final_project.test.ui;

import by.it_academy.final_project.page_object.HomePage;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CatalogPageUiTest extends BaseUiTest {
    private HomePage homePage;

    @BeforeClass
    public void onlinerHomePageNavigation() {
        homePage = new HomePage();
        homePage.navigateToOnlinerHomePage();
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Check 'Computers and Networks' menu is visible")
    @Story("'Computers and Networks' menu is visible")
    @Step("'Computers and Networks' menu is visible")
    @Test
    public void testComputersAndNetworksMenuIsVisible() {
        LOG.info("Check 'Computers and Networks' menu is visible");
        new HomePage()
                .clickOnCatalogLink()
                .clickOnCatalogNavigationClassifierLink("Компьютеры")
                .verifyComputerMenuItemsAreNotEmpty();
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Check product title and product description in 'Components' section are visible")
    @Story("Product title and product description in 'Components' section is visible")
    @Step("Product title and product description in 'Components' section is visible")
    @Test
    public void testComponentsSectionTitleAndDescriptionIsVisible() {
        LOG.info("Check product title and product description in 'Components' section are visible");
        new HomePage()
                .clickOnCatalogLink()
                .clickOnCatalogNavigationClassifierLink("Компьютеры")
                .clickOnAsideNavigationList("Комплектующие")
                .verifyDropdownDescriptionIsNotEmpty();
    }
}
package by.it_academy.final_project.page_object;

import com.codeborne.selenide.ElementsCollection;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class CatalogPage extends BasePage {
    public final ElementsCollection catalogItemTitles =
            $$x("//*[@class = 'catalog-navigation-classifier__item-title-wrapper']");
    public final ElementsCollection computersMenuItems =
            $$x("//*[@class = 'catalog-navigation-list__category' and @data-id='2']"
                    + "//*[@class = 'catalog-navigation-list__aside-item']"
                    + "//*[@class='catalog-navigation-list__aside-title']");
    public final ElementsCollection accessoriesMenuItems =
            $$x("//div[contains(@class,"
                    + "'catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active')]//a");
    public static final String CATALOG_CLASSIFIER_LINK_XPATH_PATTERN =
            "//*[@class='catalog-navigation-classifier__item-title-wrapper' and contains(text(), '%s')]";
    public static final String COMPUTERS_CLASSIFIER_LINK_XPATH_PATTERN =
            "//*[@class='catalog-navigation-list__aside-title' and contains(text(), '%s')]";


    public CatalogPage verifyCatalogItemTitles(List<String> expectedTitles) {
        catalogItemTitles.shouldHave(exactTexts(expectedTitles), ofSeconds(30));
        return this;
    }

    public CatalogPage clickOnCatalogNavigationClassifierLink(String link) {
        $x(format(CATALOG_CLASSIFIER_LINK_XPATH_PATTERN, link))
                .shouldBe(visible, ofSeconds(30))
                .click();
        return this;
    }

    public CatalogPage clickOnAsideNavigationList(String link) {
        $x(format(COMPUTERS_CLASSIFIER_LINK_XPATH_PATTERN, link))
                .shouldBe(visible, ofSeconds(30)).
                click();
        return this;
    }

    public CatalogPage verifyComputerMenuItemsAreNotEmpty() {
        computersMenuItems
                .shouldHave(sizeGreaterThan(0), ofSeconds(30))
                .should(allMatch("some menu items are empty",
                        menuItem -> !menuItem.getText().isEmpty()));
        return this;
    }

    public CatalogPage verifyDropdownDescriptionIsNotEmpty() {
        accessoriesMenuItems
                .shouldHave(sizeGreaterThan(0), ofSeconds(30))
                .should(allMatch("some menu items are empty",
                        menuItem -> !menuItem.getText().isEmpty()));
        return this;
    }
}
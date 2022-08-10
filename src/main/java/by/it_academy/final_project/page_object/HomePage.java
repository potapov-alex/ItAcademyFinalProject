package by.it_academy.final_project.page_object;

import io.qameta.allure.Step;

import static by.it_academy.final_project.enums.OnlinerPageUrls.HOME_PAGE;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class HomePage extends BasePage {
    public static final String MENU_CLASSIFIER_LINK_XPATH_PATTERN = "//span[@class='b-main-navigation__text'][contains(text(),%s)]";

    @Step("Navigate to onliner home page")
    public HomePage navigateToOnlinerHomePage() {
        open(HOME_PAGE.getUrl());
        return this;
    }

    public void clickOnMenuClassifierLink(String link) {
        $x(format(MENU_CLASSIFIER_LINK_XPATH_PATTERN, link))
                .shouldBe(visible, ofSeconds(30))
                .click();
    }

    public CatalogPage clickOnCatalogLink() {
        clickOnMenuClassifierLink("Каталог");
        return new CatalogPage();
    }
}
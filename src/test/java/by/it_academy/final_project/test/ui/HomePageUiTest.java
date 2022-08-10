package by.it_academy.final_project.test.ui;

import by.it_academy.final_project.page_object.HomePage;
import io.qameta.allure.*;
import org.testng.annotations.Test;


import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;


public class HomePageUiTest extends BaseUiTest {

    public final List<String> catalogItemTitles = Arrays.asList(
            "Onlíner Prime",
            "Электроника",
            "Компьютеры и сети",
            "Бытовая техника",
            "Стройка и ремонт",
            "Дом и сад",
            "Авто и мото",
            "Красота и спорт",
            "Детям и мамам",
            "Работа и офис");


    @Severity(SeverityLevel.NORMAL)
    @Description("Check catalog item title is visible")
    @Story("'Computers and Networks' menu is visible")
    @Step("Catalog item title is visible")
    @Test
    public void testCatalogItemTitleIsVisible() {
        LOG.info("Check catalog item title is visible");
        open("https://www.onliner.by/");
        new HomePage()
                .clickOnCatalogLink()
                .verifyCatalogItemTitles(catalogItemTitles);
    }
}
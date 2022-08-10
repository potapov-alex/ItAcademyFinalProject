package by.it_academy.final_project.test.api;

import by.it_academy.final_project.rest_api.service.ProductService;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ChooseATypeOfProductTest extends BaseTest {

    @Step("User is able to choose a product type")
    @Story("User is able to choose a product type")
    @Description("Check that user is able to choose a product type")
    @Test
    public void testUserIsAbleToChooseATypeOfProduct() {
        LOG.info("Check that user is able to choose a product type");
        ProductService productService = new ProductService();
        List<String> typesOfProducts = productService.getNameOfProductType();
        assertThat(typesOfProducts)
                .as("Name_prefix does not contains type of product")
                .allMatch(element -> element.contains("Роллы"));
        LOG.info(typesOfProducts);
    }
}
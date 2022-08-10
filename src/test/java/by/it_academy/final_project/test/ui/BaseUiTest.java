package by.it_academy.final_project.test.ui;

import by.it_academy.final_project.listeners.AllureListener;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureListener.class)
public class BaseUiTest {

    protected static final Logger LOG = Logger.getLogger(BaseUiTest.class);

    @Test
    @Step("Browser starting")
    void setUp() {
        SelenideLogger
                .addListener("AllureSelenide",
                        new AllureSelenide().screenshots(true).savePageSource(false));

    }
}
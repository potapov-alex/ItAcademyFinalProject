package by.it_academy.final_project.page_object;

import com.codeborne.selenide.Configuration;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.open;

public abstract class BasePage {

    protected static final Logger LOG = Logger.getLogger(BasePage.class);

    public BasePage() {
        Configuration.browser = "firefox";
        Configuration.startMaximized = true;
        Configuration.headless = false;
        Configuration.pageLoadTimeout = 200000;
        LOG.info("browser has been opened");
    }
}
package by.it_academy.final_project.test.api;

import by.it_academy.final_project.listeners.AllureListener;
import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;

@Listeners(AllureListener.class)
public class BaseTest {
    protected static final Logger LOG = Logger.getLogger(BaseTest.class);
}
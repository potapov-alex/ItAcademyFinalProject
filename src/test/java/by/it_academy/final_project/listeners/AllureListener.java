package by.it_academy.final_project.listeners;

import by.it_academy.final_project.utils.ScreenshotUtils;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class AllureListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        ScreenshotUtils.takeScreenshotAndAttachToAllureReport();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ScreenshotUtils.takeScreenshotAndAttachToAllureReport();
    }
}
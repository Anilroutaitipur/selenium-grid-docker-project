package stepdefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ExtentManager;

public class Hooks {

    private static ExtentReports extent;
    private static ExtentTest scenarioTest;

    @Before
    public void setup(io.cucumber.java.Scenario scenario) {
        if (extent == null) {
            extent = ExtentManager.getInstance();
        }
        scenarioTest = extent.createTest(scenario.getName());
    }

    @After
    public void tearDown(io.cucumber.java.Scenario scenario) {
        if (scenario.isFailed()) {
            scenarioTest.fail("Scenario Failed: " + scenario.getName());
        } else {
            scenarioTest.pass("Scenario Passed: " + scenario.getName());
        }
        extent.flush(); // Write to report
    }
}

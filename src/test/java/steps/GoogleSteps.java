package steps;

import base.BaseTest;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.GooglePage;

public class GoogleSteps {
    GooglePage google;

    @Given("I open Google homepage")
    public void open_google() throws Exception {
        BaseTest.setup("chrome");  // run on chrome node
        google = new GooglePage(BaseTest.driver);
        google.open();
    }

    @When("I search for {string}")
    public void search_google(String text) {
        google.search(text);
    }

    @Then("The page title should contain {string}")
    public void validate_title(String keyword) {
        Assert.assertTrue(google.getTitle().contains(keyword));
        BaseTest.tearDown();
    }
}


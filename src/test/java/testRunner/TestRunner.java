package testRunner;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
    //features = { ".//Features/AddOrganization.feature" },
    features = {".//Features"},
    glue = "stepDefinitions",
    plugin = {
        "pretty",
        "html:reports/cucumber-reports.html",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

        //"json:target/cucumber.json"
    },
    dryRun = false,
    monochrome = true,
    publish = true,
    tags = "@Regression"
)
public class TestRunner {
}


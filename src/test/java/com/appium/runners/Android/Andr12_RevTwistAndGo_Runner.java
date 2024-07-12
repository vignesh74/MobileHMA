package com.appium.runners.Android;

import com.appium.base.BaseTest;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = { "pretty"
                , "html:target/cucumber"
                , "summary"
                , "html:target/cucumber-reports/cucumber-html-reports/report.html"
                , "json:target/cucumber-reports/cucumber-json-report/cucumber.json"
                , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
        , features = "src/test/resources/features/Android"
        , glue = "com.appium.stepDefinition"
        , dryRun = false
        , monochrome = true
        , tags = "@Android12_RevE_TwistGo_WF_1")

public class Andr12_RevTwistAndGo_Runner extends BaseTest {

}



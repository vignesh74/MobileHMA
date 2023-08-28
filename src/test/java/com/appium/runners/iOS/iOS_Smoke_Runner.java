package com.appium.runners.iOS;

import com.appium.base.BaseTest;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = { "pretty"
                , "html:target/cucumber"
                , "summary"
                , "html:target/cucumber-reports/cucumber-html-reports/report.html"
                , "json:target/cucumber-reports/cucumber-json-report/cucumber.json"
                , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
        , features = "src/test/resources/features/iOS"
        , glue = "com.appium.stepDefinition"
        , dryRun = true
        , monochrome = true
        , tags = "@iOS_SmokeRun")

public class iOS_Smoke_Runner extends BaseTest {
}

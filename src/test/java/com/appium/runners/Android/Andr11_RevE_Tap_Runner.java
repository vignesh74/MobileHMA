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
        , tags = "@Android11_10_RevE_Tap_WF_5")
//        , tags = "@Android11_RevE_Tap")
//        , tags = "@Android11_RevE")

public class Andr11_RevE_Tap_Runner extends BaseTest {

}

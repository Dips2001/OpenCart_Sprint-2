package com.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features="Features",
tags="@BrowseCart",
glue ="com.BrowseCart.stepDefinition",
plugin={"html:target/cucumber-html-report", "json:target/cucumber.json","pretty:target/cucumber-pretty.txt","usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml"},
dryRun = false,
monochrome = true
)

public class OpenCartRunner {

}



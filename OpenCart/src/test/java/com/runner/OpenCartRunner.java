package com.runner;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
 
import io.cucumber.testng.PickleWrapper;

@CucumberOptions(
features="Features",
tags="@Home",
glue = "com.Home.stepDefinition",
plugin={"html:target/cucumber-html-report", "json:target/cucumber.json","pretty:target/cucumber-pretty.txt","usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml"},
dryRun = false,
monochrome = true
)



public class OpenCartRunner {
	
	 private TestNGCucumberRunner testNGCucumberRunner;
	 
	 public static WebDriver connection, driver;
	 
	 @BeforeClass(alwaysRun = true)
	 public void setUpCucumber() {
	 testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	 
	 }
	 
	 @BeforeMethod(alwaysRun = true)
	 public void setUpClass() throws Exception {
//	 System.setProperty("webdriver.chrome.driver", "E:\\\\Capgemini\\\\Internship\\\\Module-4\\\\Drivers\\\\chromedriver_win32\\\\chromedriver.exe");
//	 connection = new ChromeDriver();
//	  
//	 System.out.println(connection);
	}
	 
	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "Scenarios")
	public void Scenario(PickleWrapper pickle,FeatureWrapper cucumberFeature) {
	testNGCucumberRunner.runScenario(pickle.getPickle());
	}

	@DataProvider
	public Object[][] Scenarios() {
	return testNGCucumberRunner.provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
	testNGCucumberRunner.finish();
	}
}


package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//path of feature files and path of step definition files

@CucumberOptions(features = "src/test/resources/Feature", glue = {
		"com.testingshastra.stepdefinition" }, dryRun = false)
public class RunnerTest extends AbstractTestNGCucumberTests {

}
//we are create runner class- using runner we can execute our all Feature file at a time
//here testNG execute cucumber's features
//dryRun = true/false -dryRun only check step definition & gherkin step definition(mapping)
//cucumber provide report also 
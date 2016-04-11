package com.jf.home;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/com/jf/home/features/storeMetrics.feature"},
    snippets = SnippetType.CAMELCASE)
public class CucumberRunner {

}

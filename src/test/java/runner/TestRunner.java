package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/feature", 
glue = "stepdef", 
dryRun = !true, 
tags = "@Map",
snippets = SnippetType.CAMELCASE,
plugin = {
	    "pretty",
	    "json:target/cucumber-reports/cucumber.json",
	    "junit:target/cucumber-reports/junit-report.xml",
	    "html:target/cucumber-reports/cucumber-html"
 }

)
public class TestRunner {

}

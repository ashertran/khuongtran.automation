package cucumberOptions;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "stepDefinitions", monochrome = true, plugin = {"pretty",
        "html:target/site/cucumber-reports",
        "json:target/site/cucumber.json",
        "junit:target/site/Cucumber.xml",
        "com.cucumber.listener.ExtentCucumberFormatter:target/report.html"},
        snippets = SnippetType.CAMELCASE,
        tags = {
                "@loginFunction,@filterFunction,@sortFunction,@filterFunction,@checkAPItoGet" })//
public class RunCucumber {
    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("config/report.xml"));

    }
}

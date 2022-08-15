package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@CucumberOptions(
        plugin = {"pretty","html:src/main/resources/Output/cucumber.html",
                "json:src/main/resources/Output/cucumber.json",
                "junit:src/main/resources/Output/cucumber.xml"},
        features = {"src/main/resources/testFeature"},
        glue = {"stepDef"},
        tags = "@test3",
        dryRun = false, monochrome = true
)
//@RunWith uses Junit to run
@RunWith(Cucumber.class)
public class demoTestRunner {
}

//Using with TestNG
//public class demoTestRunner extends AbstractTestNGCucumberTests {
//}

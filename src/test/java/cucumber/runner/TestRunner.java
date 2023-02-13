package cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:src/target/cucumber-reports"},
        monochrome = true,
        tags = "@ParallelExecution",
        glue = "cucumber.steps",
        features = "src/test/resources/cucumber_features"
)
public class TestRunner {
}

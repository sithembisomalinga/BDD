package TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"C:\\Users\\Sithembiso.Malinga\\Desktop\\DevOps_Training\\CucumberBDD\\BDD_Exercise1.0\\src\\test\\java\\Features"},
        glue = {"StepDefinitions"},
        plugin = {"json:target/cucumber.json"}
)

public class TestRunner {
   // plugin = {"json:target/cucumber.json"}
}

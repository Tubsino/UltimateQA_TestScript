package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(features = "src/test/resources/features",
glue = {"stepDefinition"}, plugin = {"html:target/cucumber-report/html-report.html"}

)
public class Runner extends AbstractTestNGCucumberTests {

}

package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features={"classpath:features"}, glue={"stepDefinitions"},
        tags="@registration", monochrome = true, dryRun = false,
        plugin={"pretty", "html:target/cucumber", "json:target/cucumber.json"})

public class MainRunner extends AbstractTestNGCucumberTests {
    //to run test scenarios in parallel
    @Override
    @DataProvider(parallel = false)//if needed to run tests separately, then turn parallel=false
    public Object[][] scenarios() {
        return super.scenarios();
    }

}

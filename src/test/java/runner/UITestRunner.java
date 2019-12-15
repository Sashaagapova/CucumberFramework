package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumberHTML-report", "json:target/cucumber.json",},
        features ={"/Users/sasha/IdeaProjects/CucumberFramework/src/test/resourses/uiFeatures","/Users/sasha/IdeaProjects/CucumberFramework/src/test/resourses/dbFeatures"},

        glue = "stepDefs",
        dryRun = true,
        tags= {"@HRProject"}
        //{"@ui","@smokeTest"}

        // if it's true it is looking if we have that steps implemented in the features, it doesn't run all of them


)
public class UITestRunner {

}

package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/FeatureFiles/_01_Login.feature",
                    "src/test/java/FeatureFiles/_02_Country.feature"   //çoklu feature çalıştırmak için böyle yazılır
        },
        glue = {"StepDefinitions"},
        dryRun = true     //true olduğunda testi çalıştırmaz, sadece feature lara ait steplerin varlığını kontrol eder
        //dryRun = false    testi normal şekilde çalıştırır
)

public class _02_TestRunnerBelirliFeaturelar extends AbstractTestNGCucumberTests {
}

package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
        features = {"src/test/java/FeatureFiles/_01_Login.feature"},      //buraya çalışacak feature file ın path i verilecek.
        glue = {"StepDefinitions"}           //step definitions ın klasörü yazılacak.
)

public class _01_TestRunner extends AbstractTestNGCucumberTests {



}

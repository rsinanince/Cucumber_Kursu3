package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@Regression or @SmokeTest",   //or yazıldığı zaman hangisi varsa onu çalıştırır
        features = {"src/test/java/FeatureFiles/"},
        glue = {"StepDefinitions"}
)

public class _05_TestRunnerRegression extends AbstractTestNGCucumberTests {
  //bu kısım browser tipi vermek için ve rapora ek parametre eklemek için ayrıca kullanılacak
}

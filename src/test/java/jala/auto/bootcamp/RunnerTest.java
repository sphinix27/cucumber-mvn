package jala.auto.bootcamp;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * Runner
 */
@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = "pretty",
    features = "src/test/resources",
    glue = "jala.auto.bootcamp"
)
public class RunnerTest {


}

package step;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/scenarios"},
        glue = {"step"},
        plugin = {"pretty"},
        publish = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunnerTest  {}

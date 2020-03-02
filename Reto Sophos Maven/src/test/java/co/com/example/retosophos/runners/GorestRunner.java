package co.com.example.retosophos.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/gorest_api.feature",
        glue = {"co.com.example.retosophos.stepdefinitions"},
        snippets = SnippetType.CAMELCASE
)

public class GorestRunner {}

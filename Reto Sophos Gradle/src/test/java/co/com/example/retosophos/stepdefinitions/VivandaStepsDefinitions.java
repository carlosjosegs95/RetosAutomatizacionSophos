package co.com.example.retosophos.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static co.com.example.retosophos.questions.CheckTheProductOnBasket.theProductOnBasket;
import static co.com.example.retosophos.tasks.SelectProduct.selectsProduct;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

@RunWith(Cucumber.class)
public class VivandaStepsDefinitions {

    @Managed(driver = "chrome")
    private WebDriver browser;

    private Actor user = Actor.named("User");

    @Before
    public void setup() {
        user.can(BrowseTheWeb.with(browser));
    }

    @Given("^an user enters the vivanda page$")
    public void anUserEntersTheVivandaPage() {
        user.wasAbleTo(Open.url("https://www.vivanda.com.pe/"));
    }

    @When("^the user selects a product$")
    public void theUserSearchesTheProduct(Map<String, String> dataTable) {
        user.attemptsTo(selectsProduct(Integer.parseInt(dataTable.get("number")), dataTable.get("product")));
    }

    @Then("^the user check the product on basket$")
    public void theUserCheckTheProductOnBasket(Map<String, String> dataTable) {
        user.should(seeThat(theProductOnBasket(dataTable.get("product"))));
    }

}

package co.com.example.retosophos.stepdefinitions;

import co.com.example.retosophos.dto.User;
import co.com.example.retosophos.steps.GetSteps;
import co.com.example.retosophos.steps.PostSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class GorestStepDefinition {

    @Steps
    private PostSteps postSteps;

    @Steps
    private GetSteps getSteps;

    @When("^an user create a register using his data$")
    public void anUserCreateARegisterUsingHisData() {
        postSteps.createPostQuery();
        postSteps.postRequest();
        getSteps.getRequest();
    }

    @Then("^the user check the successful create$")
    public void theUserCheckTheSuccessfulCreate() {
        Map<String, String> userExpected = Serenity.sessionVariableCalled("userExpected");
        User userResult = Serenity.sessionVariableCalled("userResultApi");

        assertTrue(userExpected.get("first_name").equalsIgnoreCase(userResult.getFirstName()));
        assertTrue(userExpected.get("last_name").equalsIgnoreCase(userResult.getLastName()));
        assertTrue(userExpected.get("email").equalsIgnoreCase(userResult.getEmail()));
        assertTrue(userExpected.get("gender").equalsIgnoreCase(userResult.getGender()));
        assertTrue(userExpected.get("status").equalsIgnoreCase(userResult.getStatus()));

    }

}

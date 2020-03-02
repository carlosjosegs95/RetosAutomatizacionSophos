package co.com.example.retosophos.stepdefinitions;

import co.com.example.retosophos.models.User;
import co.com.example.retosophos.tasks.GetInformationOnGorestApi;
import co.com.example.retosophos.tasks.PostInformationOnGorestApi;
import co.com.example.retosophos.util.ApiRequest;
import co.com.example.retosophos.util.CommonFunctions;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import net.serenitybdd.screenplay.Actor;
import org.junit.runner.RunWith;

import java.util.Map;

import static co.com.example.retosophos.questions.CheckTheCorrectApiConsume.theCorrectApiConsume;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

@RunWith(Cucumber.class)
public class GorestStepDefinitions {

    private Actor apiUser = Actor.named("apiUser");
    private User user = new User();
    private CommonFunctions commonFunctions = new CommonFunctions();

    @When("^an user create a register using his data$")
    public void anUserCreateAregisterUsingHisData(Map<String, String> dataTable) {
        user = commonFunctions.convertMapToUserModel(dataTable);
        apiUser.attemptsTo(
                PostInformationOnGorestApi.withData(new ApiRequest().createAnUserWithGorestApi(user)),
                GetInformationOnGorestApi.ofUser()
        );
    }

    @Then("^the user check the successful create$")
    public void theUserCheckTheSuccessfulCreate() {
        apiUser.should(seeThat(theCorrectApiConsume(user)));
    }

}

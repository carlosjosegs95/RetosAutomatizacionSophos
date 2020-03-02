package co.com.example.retosophos.stepdefinitions;

import co.com.example.retosophos.steps.HomeSteps;
import co.com.example.retosophos.steps.ProductDeliverySteps;
import co.com.example.retosophos.steps.SearchSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class VivandaStepDefinition {

    @Steps
    private HomeSteps homeSteps;

    @Steps
    private SearchSteps searchSteps;

    @Steps
    private ProductDeliverySteps productDeliverySteps;

    @Given("^an user enters the vivanda page$")
    public void openHomeVivandaHomePage() {
        homeSteps.openVivandaPage();
    }

    @When("^the user selects a product$")
    public void userSelectsTheProduct() {
        homeSteps.writeProductOnSearcher("riccadonna");
        homeSteps.pushTheSearchButton();

        searchSteps.selectAnItem();
        searchSteps.selectNumberOfProducts(3);
        searchSteps.addProductToBasket();

        productDeliverySteps.closeDeliveryWindow();
    }

    @Then("^the user check the product on basket$")
    public void userValidatesTheProductOnBasket() {
        homeSteps.pushTheBasketButton();
        homeSteps.checkTheProductName("riccadonna");
    }

}

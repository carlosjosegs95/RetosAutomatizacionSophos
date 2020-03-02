package co.com.example.retosophos.steps;

import co.com.example.retosophos.pages.HomePage;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertTrue;

/**
 * Clase donde se encuentran los steps para interactuar con la
 * página principal de Vivanda
 */

public class HomeSteps extends PageObject {

    private HomePage homePage;

    @Step
    public void openVivandaPage() {
        homePage.open();
    }

    @Step
    public void writeProductOnSearcher(String product) {
        homePage.getInputProductTextField().sendKeys(product);
    }

    @Step
    public void pushTheSearchButton() {
        homePage.getButtonSearchProduct().click();
    }

    @Step
    public void pushTheBasketButton() {
        homePage.getButtonBasket().click();
    }

    @Step
    public void checkTheProductName(String product) {
        assertTrue(homePage.getItemProductNameBasket().getText().toUpperCase().contains(product.toUpperCase()));
    }
}

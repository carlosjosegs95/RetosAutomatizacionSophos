package co.com.example.retosophos.steps;

import co.com.example.retosophos.pages.SearchPage;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

/**
 * Clase donde se encuentran los steps para interactuar con la
 * página de busqueda de productos de Vivanda
 */

public class SearchSteps extends PageObject {

    private SearchPage searchPage;

    @Step
    public void selectAnItem() {
        searchPage.getItemProducts().get(0).click();
    }

    @Step
    public void selectNumberOfProducts(int number) {
        if (number > 1) {
            for (int i = 1; i < number; i++) {
                searchPage.getButtonNumberProducts().click();
            }
        }
    }

    @Step
    public void addProductToBasket() {
        searchPage.getButtonAddProduct().click();
    }

}

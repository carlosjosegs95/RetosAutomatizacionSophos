package co.com.example.retosophos.tasks;

import co.com.example.retosophos.userinterfaces.SearchPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.example.retosophos.userinterfaces.HomePage.*;
import static co.com.example.retosophos.userinterfaces.ProductDeliveryPage.BUTTON_CLOSE_DELIVERY_OPTION;
import static co.com.example.retosophos.userinterfaces.SearchPage.BUTTON_ADD_PRODUCT;
import static co.com.example.retosophos.userinterfaces.SearchPage.BUTTON_NUMBER_PRODUCTS;

/**
 * Esta clase se encarga se seleccionar un producto y agregarlo al carrito
 * en Vivanda
 */

public class SelectProduct implements Task {

    private String product;
    private int number;
    private SearchPage searchPage;

    public SelectProduct(int number, String product) {
        this.number = number;
        this.product = product;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(product).into(INPUT_PRODUCT_TEXT_FIELD),
                Click.on(BUTTON_SEARCH_PRODUCT)
        );

        actor.attemptsTo(Click.on(searchPage.getItemsProduct().get(0)));

        if (number > 1) {
            for (int i = 1; i < number; i++) {
                actor.attemptsTo(Click.on(BUTTON_NUMBER_PRODUCTS));
            }
        }

        actor.attemptsTo(
                Click.on(BUTTON_ADD_PRODUCT),
                Click.on(BUTTON_CLOSE_DELIVERY_OPTION),
                Click.on(BUTTON_BASKET)
        );

    }

    public static SelectProduct selectsProduct(int number, String product) {
        return Tasks.instrumented(SelectProduct.class, number, product);
    }
}

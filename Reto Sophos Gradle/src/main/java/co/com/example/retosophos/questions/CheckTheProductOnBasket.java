package co.com.example.retosophos.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.logging.Logger;

import static co.com.example.retosophos.userinterfaces.HomePage.ITEM_NAME_PRODUCT_BASKET;

/**
 *Esta clase valida que un producto se guarde correctamente en el
 * carrito de Vivanda
 */

public class CheckTheProductOnBasket implements Question<Boolean> {

    private String product;
    private static final Logger LOGGER = Logger.getLogger(CheckTheProductOnBasket.class.getName());

    public CheckTheProductOnBasket(String product) {
        this.product = product;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        if (ITEM_NAME_PRODUCT_BASKET.resolveFor(actor).isCurrentlyVisible()) {
            actor.attemptsTo(Ensure.that(ITEM_NAME_PRODUCT_BASKET).text().containsIgnoringCase(product));
        } else {
            LOGGER.info("THE PRODUCT ISN'T ON THE BASKET");
            return false;
        }

        return true;
    }

    public static CheckTheProductOnBasket theProductOnBasket(String product) {
        return new CheckTheProductOnBasket(product);
    }
}

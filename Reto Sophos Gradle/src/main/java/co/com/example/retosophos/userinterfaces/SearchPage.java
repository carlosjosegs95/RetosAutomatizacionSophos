package co.com.example.retosophos.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

/**
 * Clase donde se encuentran mapeados los elementos de la página de busqueda
 * en Vivanda
 */

public class SearchPage extends PageObject {

    public List<WebElementFacade> getItemsProduct() {
        return findAll(By.xpath("//*[@class='inner-producto']"));
    }

    public static final Target BUTTON_NUMBER_PRODUCTS =
            Target.the("Button number products").locatedBy("//*[@class='more-product more-qty-detail txt-green']");

    public static final Target BUTTON_ADD_PRODUCT =
            Target.the("Button add product").locatedBy("//*[@class='buy-button buy-button-ref']");
}

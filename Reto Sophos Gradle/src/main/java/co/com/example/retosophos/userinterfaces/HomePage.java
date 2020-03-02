package co.com.example.retosophos.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * Clase donde se encuentran mapeados los elementos de la página principal de Vivanda
 */

public class HomePage extends PageObject {

    public static final Target INPUT_PRODUCT_TEXT_FIELD =
            Target.the("Input product text field").locatedBy("//*[@class='input-text js-input-search']");

    public static final Target BUTTON_SEARCH_PRODUCT =
            Target.the("Button search product").locatedBy("//*[@class='icon icon-search box-search-submit js-btn-search-submit']");

    public static final Target BUTTON_BASKET =
            Target.the("Button Basket").locatedBy("//*[@class='minicart__btn__icon']");

    public static final Target ITEM_NAME_PRODUCT_BASKET =
            Target.the("Item name product basket").locatedBy("//*[@class='cartSkuName']")
                    .waitingForNoMoreThan(Duration.of(5, SECONDS));

}

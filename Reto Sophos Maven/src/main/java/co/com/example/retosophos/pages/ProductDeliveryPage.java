package co.com.example.retosophos.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

/**
 * Clase donde se encuentran mapeados los elementos de la ventana de entrega de producto
 */

public class ProductDeliveryPage extends PageObject {

    @FindBy(xpath = "//*[@class='SalesChannel__close']")
    private WebElementFacade buttonCloseDeliveryOption;

    public WebElementFacade getButtonCloseDeliveryOption() {
        return buttonCloseDeliveryOption;
    }

}

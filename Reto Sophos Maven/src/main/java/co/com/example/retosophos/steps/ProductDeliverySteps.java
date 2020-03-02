package co.com.example.retosophos.steps;

import co.com.example.retosophos.pages.ProductDeliveryPage;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

/**
 * Clase donde se encuentran los steps para interactuar con la
 * la ventana de entrega de un producto de Vivanda
 */

public class ProductDeliverySteps extends PageObject {

    private ProductDeliveryPage productDeliveryPage;

    @Step
    public void closeDeliveryWindow() {
        productDeliveryPage.getButtonCloseDeliveryOption().waitUntilClickable().click();
    }

}

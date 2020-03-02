package co.com.example.retosophos.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Clase donde se encuentran mapeados los elementos de la página de busqueda
 * en Vivanda
 */

public class SearchPage extends PageObject {

    @FindAll({ @FindBy(xpath = "//*[@class='inner-producto']")})
    private List<WebElementFacade> itemProducts;

    @FindBy(xpath = "//*[@class='more-product more-qty-detail txt-green']")
    private WebElementFacade buttonNumberProducts;

    @FindBy(xpath = "//*[@class='buy-button buy-button-ref']")
    private WebElementFacade buttonAddProduct;

    public List<WebElementFacade> getItemProducts() { return itemProducts; }

    public WebElementFacade getButtonNumberProducts() {
        return buttonNumberProducts;
    }

    public WebElementFacade getButtonAddProduct() {
        return buttonAddProduct;
    }

}

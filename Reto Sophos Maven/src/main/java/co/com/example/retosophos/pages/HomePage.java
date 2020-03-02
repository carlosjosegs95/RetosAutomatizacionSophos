package co.com.example.retosophos.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

/**
 * Clase donde se encuentran mapeados los elementos de la página principal de Vivanda
 */

@DefaultUrl("https://www.vivanda.com.pe/")
public class HomePage extends PageObject {

    @FindBy(xpath = "//*[@class='input-text js-input-search']")
    private WebElementFacade inputProductTextField;

    @FindBy(xpath = "//*[@class='icon icon-search box-search-submit js-btn-search-submit']")
    private WebElementFacade buttonSearchProduct;

    @FindBy(xpath = "//*[@class='minicart__btn__icon']")
    private WebElementFacade buttonBasket;

    @FindBy(xpath = "//*[@class='cartSkuName']")
    private WebElementFacade itemProductNameBasket;

    public WebElementFacade getInputProductTextField() {
        return inputProductTextField;
    }

    public WebElementFacade getButtonSearchProduct() {
        return buttonSearchProduct;
    }

    public WebElementFacade getButtonBasket() {
        return buttonBasket;
    }

    public WebElementFacade getItemProductNameBasket() {
        return itemProductNameBasket;
    }

}

package co.com.example.retosophos.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * Clase donde se encuentran mapeados los elementos de la ventana de entrega de producto
 */

public class ProductDeliveryPage extends PageObject {

    public static final Target BUTTON_CLOSE_DELIVERY_OPTION =
            Target.the("Button close delivery option").located(By.xpath("//*[@class='SalesChannel__close']"))
                    .waitingForNoMoreThan(Duration.of(5, SECONDS));

}

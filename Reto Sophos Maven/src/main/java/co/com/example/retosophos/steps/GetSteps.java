package co.com.example.retosophos.steps;

import co.com.example.retosophos.utilities.GetInformationOnGorestApi;
import net.thucydides.core.annotations.Step;

/**
 * Clase donde se encuentran los steps necesarios para realizar
 * una petición GET a la API de Gorest
 */

public class GetSteps {

    private GetInformationOnGorestApi getInformationOnGorestApi = new GetInformationOnGorestApi();

    @Step
    public void getRequest() {
        getInformationOnGorestApi.getRequestOnGorest();
    }

}

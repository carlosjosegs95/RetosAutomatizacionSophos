package co.com.example.retosophos.steps;

import co.com.example.retosophos.utilities.PostInformationOnGorestApi;
import co.com.example.retosophos.utilities.apiconnections.ApiRequest;
import net.thucydides.core.annotations.Step;

/**
 * Clase donde se encuentran steps necesarios para realizar
 * una petición POST en la API de Gorest
 */

public class PostSteps {

    private String json;
    private PostInformationOnGorestApi postInformationOnGorestApi = new PostInformationOnGorestApi();

    @Step
    public void createPostQuery() {
        json = ApiRequest.createAnUserWithGorestApi();
    }

    @Step
    public void postRequest() {
        postInformationOnGorestApi.postRequestOnGorest(json);
    }

}

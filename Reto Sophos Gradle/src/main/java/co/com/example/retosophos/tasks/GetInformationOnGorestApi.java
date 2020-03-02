package co.com.example.retosophos.tasks;

import co.com.example.retosophos.exceptions.MyBusinessException;
import co.com.example.retosophos.integrations.GorestApiHttpRequest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import static co.com.example.retosophos.exceptions.ExceptionMessages.EXCEPTIONS_ERROR_QUERY_RESPONSE;
import static co.com.example.retosophos.exceptions.ExceptionMessages.EXCEPTIONS_ERROR_QUERY_REQUEST;
import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 *Esta clase realiza la consulta de un usuario en Gorest API dado el id
 * correspondiente al registro creado con la petición POST
 */

public class GetInformationOnGorestApi implements Task {

    private CloseableHttpClient clientHTTP = HttpClients.createDefault();

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {

            HttpGet httpGet = new GorestApiHttpRequest().setGetAuthorization();
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                @Override
                public String handleResponse(
                        final HttpResponse response) throws IOException {
                    if (response.getStatusLine().getStatusCode() >= 400){
                        throw new MyBusinessException(EXCEPTIONS_ERROR_QUERY_REQUEST.getMessage());
                    }
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                }
            };

            String responseBody = this.clientHTTP.execute(httpGet,responseHandler);
            new GorestApiHttpRequest().responseHttpGetMethod(responseBody);

        }catch (IOException e){
            throw new MyBusinessException(EXCEPTIONS_ERROR_QUERY_RESPONSE.getMessage());
        }
    }

    public static GetInformationOnGorestApi ofUser() {
        return instrumented(GetInformationOnGorestApi.class);
    }

}

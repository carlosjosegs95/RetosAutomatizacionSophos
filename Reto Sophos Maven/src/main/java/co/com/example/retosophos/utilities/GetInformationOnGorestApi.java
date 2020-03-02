package co.com.example.retosophos.utilities;

import co.com.example.retosophos.utilities.apiconnections.GorestApiHttpRequest;
import co.com.example.retosophos.utilities.exceptions.MyBusinessException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import static co.com.example.retosophos.utilities.exceptions.ExceptionMessages.EXCEPTIONS_ERROR_QUERY_REQUEST;
import static co.com.example.retosophos.utilities.exceptions.ExceptionMessages.EXCEPTIONS_ERROR_QUERY_RESPONSE;

public class GetInformationOnGorestApi {

    private CloseableHttpClient clientHTTP = HttpClients.createDefault();

    public void getRequestOnGorest() {

        try {

            HttpGet httpGet = new GorestApiHttpRequest().setGetAuthorization();
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

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

}

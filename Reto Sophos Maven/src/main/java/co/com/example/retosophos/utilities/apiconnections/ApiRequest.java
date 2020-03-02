package co.com.example.retosophos.utilities.apiconnections;

import co.com.example.retosophos.utilities.CommonFunctions;
import com.google.gson.Gson;
import net.serenitybdd.core.Serenity;

import java.util.HashMap;
import java.util.Map;

public class ApiRequest {

    /**
     * Query para crear un usuario en Gorest API
     */

    public static String createAnUserWithGorestApi() {

        Map<String, String> userGorest = new HashMap<String, String>();
        Gson gson = new Gson();

        userGorest.put("first_name", "Carlos");
        userGorest.put("last_name", "Guerrero");
        userGorest.put("gender", "male");
        userGorest.put("email", new CommonFunctions().getRandomString(5) + "@gmail.com");
        userGorest.put("status", "active");

        Serenity.setSessionVariable("userExpected").to(userGorest);

        return gson.toJson(userGorest);
    }

}

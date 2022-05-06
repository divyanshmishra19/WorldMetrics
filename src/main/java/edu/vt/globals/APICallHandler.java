package edu.vt.globals;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APICallHandler {
    public String getResponseFromServer(String target, Object payload) {
        ObjectMapper Obj = new ObjectMapper();
        String responseString = "";
        try {
            String jsonStr = Obj.writeValueAsString(payload);
            URI uri = new URI(target);
            HttpRequest request = HttpRequest.newBuilder(uri)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonStr))
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            responseString = response.body();

            if (responseString.contains("error") && responseString.contains("low_quality")) {
                Methods.showMessage("Fatal", "Application Failed!",
                        "An unrecognised error has occurred!.");
                return "ERROR";
            }

        } catch (Exception e) {
            Methods.showMessage("Fatal", "Application Failed!",
                    "An unrecognised error has occurred!.");
            return "ERROR";
        }
        return responseString;
    }
}

package edu.vt.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.vt.globals.APICallHandler;
import edu.vt.globals.Constants;
import edu.vt.globals.Methods;
import edu.vt.responses.CustomComparatorResponse;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named("metricsController")
@SessionScoped
public class CustomComparatorController implements Serializable {

    private static APICallHandler apiCallHandler;

    private CustomComparatorResponse response;
    private List<String> countryList;
    private List<String> metricList;

    static {
        apiCallHandler = new APICallHandler();
    }

    public CustomComparatorResponse getComparativeCharts() {
        Map<String, List<String>> comparativeChartPayload = new HashMap<>();
        comparativeChartPayload.put("countryList", countryList);
        comparativeChartPayload.put("metricList", metricList);

        try {
            String responseString = apiCallHandler.getResponseFromServer(Constants.GET_COMPARATIVE_CHARTS, comparativeChartPayload);
            response = new ObjectMapper().readValue(responseString, CustomComparatorResponse.class);
        } catch (Exception e) {
            Methods.showMessage("Fatal", "Application Failed!",
                    "An unrecognised error has occurred!.");
            return new CustomComparatorResponse();
        }
        return response;
    }

    public static APICallHandler getApiCallHandler() {
        return apiCallHandler;
    }

    public static void setApiCallHandler(APICallHandler apiCallHandler) {
        CustomComparatorController.apiCallHandler = apiCallHandler;
    }

    public CustomComparatorResponse getResponse() {
        return response;
    }

    public void setResponse(CustomComparatorResponse response) {
        this.response = response;
    }

    public List<String> getMetricList() {
        return metricList;
    }

    public void setMetricList(List<String> metricList) {
        this.metricList = metricList;
    }

    public List<String> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<String> countryList) {
        this.countryList = countryList;
    }
}

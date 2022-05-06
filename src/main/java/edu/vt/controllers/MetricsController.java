package edu.vt.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.vt.entities.CountryData;
import edu.vt.responses.CountryViewResponse;
import edu.vt.responses.MetricResponse;
import edu.vt.globals.APICallHandler;
import edu.vt.globals.Constants;
import edu.vt.globals.Methods;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

@Named("metricsController")
@SessionScoped
public class MetricsController implements Serializable {

    private static APICallHandler apiCallHandler;

    private List<CountryData> metricRows;
    private CountryData selected;
    private String metricCode;
    private MetricResponse metricResponse;
    private CountryViewResponse countryViewResponse;


    static {
        apiCallHandler = new APICallHandler();
    }

    public String setMetric(int a) {
        switch (a) {
            case 1:
                metricCode = Constants.GDP;
                break;
            case 2:
                metricCode = Constants.GDP;
                break;
            case 3:
                metricCode = Constants.GDP;
                break;
            case 4:
                metricCode = Constants.GDP;
                break;
            case 5:
                metricCode = Constants.GDP;
                break;
            case 6:
                metricCode = Constants.GDP;
                break;
            case 7:
                metricCode = Constants.GDP;
                break;
            case 8:
                metricCode = Constants.GDP;
                break;
            case 9:
                metricCode = Constants.GDP;
                break;
            default:
                metricCode = Constants.GDP;
                break;
        }
        return "/metrics/List?faces-redirect=true";
    }

    public MetricResponse getMetricRows() {
        try {
            String responseString = apiCallHandler.getResponseFromServer(Constants.GET_METRICS, metricCode);
            metricResponse = new ObjectMapper().readValue(responseString, MetricResponse.class);
        } catch (Exception e) {
            Methods.showMessage("Fatal", "Application Failed!",
                    "An unrecognised error has occurred!.");
            return new MetricResponse();
        }
        return metricResponse;
    }

    public CountryViewResponse viewCountry() {
        Map<String, String> viewCountryPayLoad = new HashMap<>();
        viewCountryPayLoad.put("countryName", selected.getCountryName());
        viewCountryPayLoad.put("metricCode", metricCode);

        try {
            String responseString = apiCallHandler.getResponseFromServer(Constants.VIEW_COUNTRY, viewCountryPayLoad);
            countryViewResponse = new ObjectMapper().readValue(responseString, CountryViewResponse.class);
        } catch (Exception e) {
            Methods.showMessage("Fatal", "Application Failed!",
                    "An unrecognised error has occurred!.");
            return new CountryViewResponse();
        }
        return countryViewResponse;
    }

    public void unselect() {
        selected = null;
    }

    public void setMetricRows(List<CountryData> metricRows) {
        this.metricRows = metricRows;
    }

    public CountryData getSelected() {
        return selected;
    }

    public void setSelected(CountryData selected) {
        this.selected = selected;
    }

    public String getMetricCode() {
        return metricCode;
    }

    public void setMetricCode(String metricCode) {
        this.metricCode = metricCode;
    }

    public MetricResponse getMetricResponse() {
        return metricResponse;
    }

    public void setMetricResponse(MetricResponse metricResponse) {
        this.metricResponse = metricResponse;
    }

    public static APICallHandler getApiCallHandler() {
        return apiCallHandler;
    }

    public static void setApiCallHandler(APICallHandler apiCallHandler) {
        MetricsController.apiCallHandler = apiCallHandler;
    }

    public CountryViewResponse getCountryViewResponse() {
        return countryViewResponse;
    }

    public void setCountryViewResponse(CountryViewResponse countryViewResponse) {
        this.countryViewResponse = countryViewResponse;
    }
}

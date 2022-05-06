package edu.vt.controllers;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.vt.entityBeans.CountryData;
import edu.vt.entityBeans.MetricPayload;
import edu.vt.entityBeans.MetricResponse;
import edu.vt.globals.Constants;
import edu.vt.globals.Methods;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

@Named("metricsController")
@SessionScoped
public class MetricsController implements Serializable{
    private List<CountryData> metricRows;
    private CountryData selected;
    private String metricCode;
    private MetricResponse metricResponse;

    public String setMetric(int a)
    {
        switch (a)
        {
            case 1:
                metricCode = Constants.GDP;
                break;
            default:
                metricCode = Constants.GDP;
                break;
        }
        return "/metrics/List?faces-redirect=true";
    }

    public MetricResponse getMetricRows() {

        ObjectMapper Obj = new ObjectMapper();
        /*
        try {
            String jsonStr = Obj.writeValueAsString(metricCode);

            String TARGET = "KUNALS_SERVER_URL";
            URI uri = new URI(TARGET);
            HttpRequest request = HttpRequest.newBuilder(uri)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonStr))
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String responseString = response.body();

            if(responseString.contains("error") && responseString.contains("low_quality"))
            {
                Methods.showMessage("Fatal", "Application Failed!",
                        "An unrecognised error has occurred!.");
                return new MetricResponse();
            }

            metricResponse = new ObjectMapper().readValue(responseString, MetricResponse.class);
            metricRows = metricResponse.getCountryData();

        } catch (Exception e) {
            Methods.showMessage("Fatal", "Application Failed!",
                    "An unrecognised error has occurred!.");
            return new MetricResponse();
        }
         */
        CountryData countryData = new CountryData();
        countryData.setCountryName("TEST");
        countryData.setChartURL("TEST");
        countryData.setDetail("TEST");
        countryData.setValue(34.5);
        countryData.setYear(2009);

        List<CountryData> countryDataList = new ArrayList<>();

        countryDataList.add(countryData);
        metricResponse = new MetricResponse();
        metricResponse.setCountryData(countryDataList);
        metricResponse.setMetricName("TEST");
        metricResponse.setMetricSource("fake source");
        metricResponse.setMetricDetail("TESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETS");

        return metricResponse;
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
        metricResponse = new MetricResponse();
        metricResponse.setMetricName("TEST");
        metricResponse.setMetricSource("fake source");
        metricResponse.setMetricDetail("TESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETSTESTETS");
        return metricResponse;
    }

    public void setMetricResponse(MetricResponse metricResponse) {
        this.metricResponse = metricResponse;
    }
}

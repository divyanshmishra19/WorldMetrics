package edu.vt.controllers;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.vt.entityBeans.Metric;
import edu.vt.entityBeans.MetricPayload;
import edu.vt.globals.Constants;
import edu.vt.globals.Methods;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
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
    private List<Metric> metricRows;
    private Metric selected;
    private String metricCode;
    private MetricPayload payload;
    private String metricName;

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

    public List<Metric> getMetricRows() {
        payload = new MetricPayload(new ArrayList<String>(), new ArrayList<String>(), metricCode);

        ObjectMapper Obj = new ObjectMapper();
        /*
        try {
            String jsonStr = Obj.writeValueAsString(payload);

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
                return Collections.emptyList();
            }

            Map<String, Map<String, Map<String, Object>>> result = new ObjectMapper().readValue(responseString, HashMap.class);
            selected.setMetricValue(123.45);
            selected.setCountryName("India");
            selected.setYear("1987");

        } catch (Exception e) {
            Methods.showMessage("Fatal", "Application Failed!",
                    "An unrecognised error has occurred!.");
            return Collections.emptyList();
        }

         */
        selected = new Metric();
        selected.setMetricValue(123.45);
        selected.setCountryName("India");
        selected.setYear("1987");
        metricRows = new ArrayList<>();
        metricRows.add(selected);

        selected = new Metric();
        selected.setMetricValue(456.78);
        selected.setCountryName("USA");
        selected.setYear("2021");
        metricRows.add(selected);

        selected = new Metric();
        selected.setMetricValue(234.98);
        selected.setCountryName("Russia");
        selected.setYear("2002");
        metricRows.add(selected);

        selected = new Metric();
        selected.setMetricValue(6.78);
        selected.setCountryName("Japan");
        selected.setYear("2015");
        metricRows.add(selected);

        selected = new Metric();
        selected.setMetricValue(46.7);
        selected.setCountryName("China");
        selected.setYear("2013");
        metricRows.add(selected);

        selected = new Metric();
        selected.setMetricValue(4578.0);
        selected.setCountryName("Egypt");
        selected.setYear("2012");
        metricRows.add(selected);

        return metricRows;
    }

    public void unselect() {
        selected = null;
    }

    public void setMetricRows(List<Metric> metricRows) {
        this.metricRows = metricRows;
    }

    public Metric getSelected() {
        return selected;
    }

    public void setSelected(Metric selected) {
        this.selected = selected;
    }

    public String getMetricCode() {
        return metricCode;
    }

    public void setMetricCode(String metricCode) {
        this.metricCode = metricCode;
    }

    public MetricPayload getPayload() {
        return payload;
    }

    public void setPayload(MetricPayload payload) {
        this.payload = payload;
    }

    public String getMetricName() {
        return "GDP";
    }

    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }
}

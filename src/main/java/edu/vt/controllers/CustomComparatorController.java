package edu.vt.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.vt.globals.APICallHandler;
import edu.vt.globals.Constants;
import edu.vt.globals.Methods;
import edu.vt.responses.CustomComparatorResponse;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

@Named("customComparatorController")
@SessionScoped
public class CustomComparatorController implements Serializable {

    private static APICallHandler apiCallHandler;

    private CustomComparatorResponse response;
    private String countryListStr;
    private List<SelectItem> metrics;
    private String[] selectedMetrics;

    @PostConstruct
    public void init() {
        metrics = new ArrayList<>();
        SelectItemGroup economicMetrics = new SelectItemGroup("Economic Metrics");
        economicMetrics.setSelectItems(new SelectItem[]{
                new SelectItem("GDP", "GDP"),
                new SelectItem("Metric1", "Metric1"),
                new SelectItem("Metric2", "Metric2")
        });

        SelectItemGroup socialMetrics = new SelectItemGroup("Social Metrics");
        socialMetrics.setSelectItems(new SelectItem[]{
                new SelectItem("Metric3", "Metric3"),
                new SelectItem("Metric4", "Metric4"),
                new SelectItem("Metric5", "Metric5")
        });

        SelectItemGroup healthMetrics = new SelectItemGroup("Health Metrics");
        healthMetrics.setSelectItems(new SelectItem[]{
                new SelectItem("Metric7", "Metric7"),
                new SelectItem("Metric8", "Metric8"),
                new SelectItem("Metric9", "Metric9")
        });

        metrics.add(economicMetrics);
        metrics.add(socialMetrics);
        metrics.add(healthMetrics);
    }

    static {
        apiCallHandler = new APICallHandler();
    }

    public String getComparativeCharts() {
        Map<String, List<String>> comparativeChartPayload = getPayoadFromInput();

        try {
            String responseString = apiCallHandler.getResponseFromServer(Constants.GET_COMPARATIVE_CHARTS, comparativeChartPayload);
            response = new ObjectMapper().readValue(responseString, CustomComparatorResponse.class);
        } catch (Exception e) {
            Methods.showMessage("Fatal", "Application Failed!",
                    "An unrecognised error has occurred!.");
            response = new CustomComparatorResponse();
            return "/metrics/demo?faces-redirect=true";
        }
        return "/charts/ChartTable.xhtml?faces-redirect=true";
    }

    private Map<String, List<String>> getPayoadFromInput() {
        List<String> metricList = new ArrayList<>(Arrays.asList(selectedMetrics));
        List<String> countryList = new ArrayList<>(Arrays.asList(countryListStr.replace(" ", "").split(",")));

        Map<String, List<String>> payload = new HashMap<>();
        payload.put("countryList", countryList);
        payload.put("metricsList", metricList);

        return payload;
    }

    public String cancel() {
        return "/metrics/Visualize?faces-redirect=true";
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

    public List<SelectItem> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<SelectItem> metrics) {
        this.metrics = metrics;
    }

    public String[] getSelectedMetrics() {
        return selectedMetrics;
    }

    public void setSelectedMetrics(String[] selectedMetrics) {
        this.selectedMetrics = selectedMetrics;
    }

    public String getCountryListStr() {
        return countryListStr;
    }

    public void setCountryListStr(String countryListStr) {
        this.countryListStr = countryListStr;
    }
}

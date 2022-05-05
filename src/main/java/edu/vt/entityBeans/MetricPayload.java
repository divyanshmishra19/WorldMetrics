package edu.vt.entityBeans;

import java.util.List;

public class MetricPayload {
    private List<String> countries;
    private List<String> years;
    private String metricCode;

    public MetricPayload(List<String> countries, List<String> years, String metricCode) {
        this.countries = countries;
        this.years = years;
        this.metricCode = metricCode;
    }

    public MetricPayload() {
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getYears() {
        return years;
    }

    public void setYears(List<String> years) {
        this.years = years;
    }

    public String getMetricCode() {
        return metricCode;
    }

    public void setMetricCode(String metricCode) {
        this.metricCode = metricCode;
    }
}

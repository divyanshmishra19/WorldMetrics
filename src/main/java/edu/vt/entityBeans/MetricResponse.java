package edu.vt.entityBeans;

import java.util.List;

public class MetricResponse {
    private String metricName;
    private String metricDetail;
    private String metricSource;
    private List<CountryData> countryData;

    public String getMetricName() {
        return metricName;
    }

    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    public String getMetricDetail() {
        return metricDetail;
    }

    public void setMetricDetail(String metricDetail) {
        this.metricDetail = metricDetail;
    }

    public String getMetricSource() {
        return metricSource;
    }

    public void setMetricSource(String metricSource) {
        this.metricSource = metricSource;
    }

    public List<CountryData> getCountryData() {
        return countryData;
    }

    public void setCountryData(List<CountryData> countryData) {
        this.countryData = countryData;
    }
}

package edu.vt.responses;

import edu.vt.entities.MetricChart;

import java.util.List;

public class CustomMetricResponse {
    private List<MetricChart> metricCharts;

    public List<MetricChart> getMetricCharts() {
        return metricCharts;
    }

    public void setMetricCharts(List<MetricChart> metricCharts) {
        this.metricCharts = metricCharts;
    }
}

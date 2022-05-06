package edu.vt.responses;

import edu.vt.entities.MetricChart;

import java.util.List;

public class CustomComparatorResponse {
    private List<MetricChart> charts;

    public List<MetricChart> getCharts() {
        return charts;
    }

    public void setCharts(List<MetricChart> charts) {
        this.charts = charts;
    }
}

package edu.vt.responses;

import edu.vt.entities.MetricChart;

import java.util.List;

public class CustomComparatorResponse {
    private List<MetricChart> data;

    public List<MetricChart> getData() {
        return data;
    }

    public void setData(List<MetricChart> data) {
        this.data = data;
    }
}

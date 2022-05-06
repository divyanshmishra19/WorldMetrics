package edu.vt.entityBeans;

import java.util.List;

public class CountryData {
    private String countryName;
    private String flagURL;
    private String chartURL;
    private String detail;
    private Integer year;
    private Double value;


    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getFlagURL() {
        return flagURL;
    }

    public void setFlagURL(String flagURL) {
        this.flagURL = flagURL;
    }

    public String getChartURL() {
        return chartURL;
    }

    public void setChartURL(String chartURL) {
        this.chartURL = chartURL;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}

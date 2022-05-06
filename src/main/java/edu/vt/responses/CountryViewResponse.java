package edu.vt.responses;

public class CountryViewResponse {
    private String countryName;
    private String countryDetails;
    private String flagURL;
    private String chartURL;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryDetails() {
        return countryDetails;
    }

    public void setCountryDetails(String countryDetails) {
        this.countryDetails = countryDetails;
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
}

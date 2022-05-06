package edu.vt.entities;

import java.util.List;
import java.util.Map;

public class CustomMetricQuiz {
    private Map<String, Integer> quizValue;
    private List<String> countryList;

    public Map<String, Integer> getQuizValue() {
        return quizValue;
    }

    public void setQuizValue(Map<String, Integer> quizValue) {
        this.quizValue = quizValue;
    }

    public List<String> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<String> countryList) {
        this.countryList = countryList;
    }
}

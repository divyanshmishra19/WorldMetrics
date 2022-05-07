package edu.vt.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.vt.globals.APICallHandler;
import edu.vt.globals.Constants;
import edu.vt.globals.Methods;
import edu.vt.responses.CustomMetricResponse;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

@Named("customMetricController")
@SessionScoped
public class CustomMetricController implements Serializable {
    private static APICallHandler apiCallHandler;

    private CustomMetricResponse response;
    private List<String> quizAnswers;
    private String countryListStr;
    private String answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9;


    static {
        apiCallHandler = new APICallHandler();
    }

    @PostConstruct
    public void init() {
        quizAnswers = new ArrayList<String>();
        quizAnswers.add("Disagree");
        quizAnswers.add("Slightly Disagree");
        quizAnswers.add("Neither Agree Nor Disagree");
        quizAnswers.add("Slightly Agree");
        quizAnswers.add("Agree");
    }

    public String getCustomMetricsCharts() {
        Map<String, Object> comparativeChartPayload = getPayoadFromInput();

        try {
            String responseString = apiCallHandler.getResponseFromServer(Constants.GET_CUSTOM_METRICS, comparativeChartPayload);
            response = new ObjectMapper().readValue(responseString, CustomMetricResponse.class);
        } catch (Exception e) {
            Methods.showMessage("Fatal", "Application Failed!",
                    "An unrecognised error has occurred!.");
            return "/metrics/CustomMetricQuiz.xhtml?faces-redirect=true";
        }
        return "/charts/CustomMetricChart.xhtml?faces-redirect=true";
    }

    private Map<String, Object> getPayoadFromInput() {
        Map<String, Object> payload = new HashMap<>();
        List<String> answers = List.of(answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9);
        List<String> countryList = new ArrayList<>(Arrays.asList(countryListStr.replace(" ", "").split(",")));

        Map<String, Object> quizScore;
        List<Object> quizValues = new ArrayList<>();
        for(int i=0;i<9;i++)
        {
            quizScore = new HashMap<>();
            quizScore.put("metric", Constants.METRIC_CODE_LIST[i]);
            quizScore.put("value", getScore(answers.get(i)));
            quizValues.add(quizScore);
        }
        payload.put("countryList", countryList);
        payload.put("quizValue", quizValues);
        return payload;
    }

    private Integer getScore(String s)
    {
        if(s.equals("Disagree"))
            return 1;
        else if(s.equals("Slightly Disagree"))
            return 2;
        else if(s.equals("Neither Agree Nor Disagree"))
            return 3;
        else if(s.equals("Slightly Agree"))
            return 4;
        else if(s.equals("Agree"))
            return 5;
        else
            return 0;
    }

    public String cancel() {
        return "/metrics/CustomMetricQuiz?faces-redirect=true";
    }

    public static APICallHandler getApiCallHandler() {
        return apiCallHandler;
    }

    public static void setApiCallHandler(APICallHandler apiCallHandler) {
        CustomMetricController.apiCallHandler = apiCallHandler;
    }

    public CustomMetricResponse getResponse() {
        return response;
    }

    public void setResponse(CustomMetricResponse response) {
        this.response = response;
    }

    public List<String> getQuizAnswers() {
        return quizAnswers;
    }

    public void setQuizAnswers(List<String> quizAnswers) {
        this.quizAnswers = quizAnswers;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getAnswer5() {
        return answer5;
    }

    public void setAnswer5(String answer5) {
        this.answer5 = answer5;
    }

    public String getAnswer6() {
        return answer6;
    }

    public void setAnswer6(String answer6) {
        this.answer6 = answer6;
    }

    public String getAnswer7() {
        return answer7;
    }

    public void setAnswer7(String answer7) {
        this.answer7 = answer7;
    }

    public String getAnswer8() {
        return answer8;
    }

    public void setAnswer8(String answer8) {
        this.answer8 = answer8;
    }

    public String getAnswer9() {
        return answer9;
    }

    public void setAnswer9(String answer9) {
        this.answer9 = answer9;
    }

    public String getCountryListStr() {
        return countryListStr;
    }

    public void setCountryListStr(String countryListStr) {
        this.countryListStr = countryListStr;
    }
}

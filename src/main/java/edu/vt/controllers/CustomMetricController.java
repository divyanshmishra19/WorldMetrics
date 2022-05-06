package edu.vt.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.vt.entities.CustomMetricQuiz;
import edu.vt.globals.APICallHandler;
import edu.vt.globals.Constants;
import edu.vt.globals.Methods;
import edu.vt.responses.CustomMetricResponse;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("metricsController")
@SessionScoped
public class CustomMetricController implements Serializable {
    private static APICallHandler apiCallHandler;

    public CustomMetricResponse response;
    public CustomMetricQuiz quiz;

    static {
        apiCallHandler = new APICallHandler();
    }

    public CustomMetricResponse getCustomMetricsCharts() {
        try {
            String responseString = apiCallHandler.getResponseFromServer(Constants.GET_CUSTOM_METRICS, quiz);
            response = new ObjectMapper().readValue(responseString, CustomMetricResponse.class);
        } catch (Exception e) {
            Methods.showMessage("Fatal", "Application Failed!",
                    "An unrecognised error has occurred!.");
            return new CustomMetricResponse();
        }
        return response;
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

    public CustomMetricQuiz getQuiz() {
        return quiz;
    }

    public void setQuiz(CustomMetricQuiz quiz) {
        this.quiz = quiz;
    }
}

package edu.vt.controllers;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("graphController")
@SessionScoped
public class GraphController implements Serializable {
    private List<SelectItem> metrics;
    private String[] selectedMetrics;

    @PostConstruct
    public void init()
    {
        metrics = new ArrayList<>();
        SelectItemGroup economicMetrics = new SelectItemGroup("Economic Metrics");
        economicMetrics.setSelectItems(new SelectItem[]{
                new SelectItem("GDP", "GDP"),
                new SelectItem("Metric1", "Metric1"),
                new SelectItem("Metric2", "Metric2")
        });

        SelectItemGroup socialMetrics = new SelectItemGroup("Social Metrics");
        socialMetrics.setSelectItems(new SelectItem[]{
                new SelectItem("Metric3", "Metric3"),
                new SelectItem("Metric4", "Metric4"),
                new SelectItem("Metric5", "Metric5")
        });

        SelectItemGroup healthMetrics = new SelectItemGroup("Health Metrics");
        healthMetrics.setSelectItems(new SelectItem[]{
                new SelectItem("Metric7", "Metric7"),
                new SelectItem("Metric8", "Metric8"),
                new SelectItem("Metric9", "Metric9")
        });



        metrics.add(economicMetrics);
        metrics.add(socialMetrics);
        metrics.add(healthMetrics);
    }
    public String showGraph()
    {
        return "/metrics/Visualize?faces-redirect=true";
    }

    public String cancel()
    {
        return "/metrics/Visualize?faces-redirect=true";
    }

    public String renderGraphs()
    {
        return "/metrics/demo?faces-redirect=true";
    }

    public List<SelectItem> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<SelectItem> metrics) {
        this.metrics = metrics;
    }

    public String[] getSelectedMetrics() {
        return selectedMetrics;
    }

    public void setSelectedMetrics(String[] selectedMetrics) {
        this.selectedMetrics = selectedMetrics;
    }
}

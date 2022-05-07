package edu.vt.globals;

public class Constants {
    //Metrics
    public static final String GDP = "GDP";
    public static final String CPI = "CPI";
    public static final String POVERTY = "POVERTY";
    public static final String HUNGER = "HUNGER";
    public static final String CHILD_MORTALITY = "CHILD_MORTALITY";
    public static final String LIFE_EXPECTANCY = "LIFE_EXPECTANCY";
    public static final String POPULATION = "POPULATION";
    public static final String HAPPINESS = "HAPPINESS";
    public static final String ENERGY_CONSUMPTION = "ENERGY_CONSUMPTION";

    public static final String METRIC_CODE_LIST[] = {"GDP",
            "CPI",
            "POVERTY",
            "HUNGER",
            "CHILD_MORTALITY",
            "LIFE_EXPECTANCY",
            "POPULATION",
            "HAPPINESS",
            "ENERGY_CONSUMPTION"
    };

    // URLs
    public static final String GET_METRICS = "https://iu0b98.deta.dev/getMetric";
    public static final String VIEW_COUNTRY = "https://iu0b98.deta.dev/getCountryView";
    public static final String GET_COMPARATIVE_CHARTS = "https://iu0b98.deta.dev/getCustomComparator";
    public static final String GET_CUSTOM_METRICS = "https://iu0b98.deta.dev/getCustomMetric";
}


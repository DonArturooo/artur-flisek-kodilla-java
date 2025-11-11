package com.kodilla.testing.weather.stub;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double calculateAverageTemperature () {
        double sum = 0.0;

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            sum += temperature.getValue();
        }

        return new BigDecimal(
                sum / temperatures.getTemperatures().size()
        ).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double calculateMedianTemperature () {
        List<Double> temp = new ArrayList<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            temp.add(temperature.getValue());
        }

        temp.sort(Double::compare);

        return new BigDecimal(
                temp.size() % 2 == 0 ?
                        (temp.get(temp.size() / 2 - 1) + temp.get(temp.size() / 2)) / 2 :
                        temp.get(temp.size() / 2)
        ).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}

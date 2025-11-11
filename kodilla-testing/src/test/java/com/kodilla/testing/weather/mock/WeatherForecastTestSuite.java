package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {
    @Mock
    static Temperatures temperaturesMock = mock(Temperatures.class);
    static WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

    @BeforeAll
    public static void beforeAll() {
        when(temperaturesMock.getTemperatures()).thenReturn(getMockTemperatures());
    }

    @Test
    void testCalculateForecastWithMock() {
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    void testCalculateAverageTemperature() {
        Assertions.assertEquals(25.56, weatherForecast.calculateAverageTemperature(), 0.01);
    }

    @Test
    void testCalculateMedianTemperature() {
        Assertions.assertEquals(25.5, weatherForecast.calculateMedianTemperature(), 0.01);
    }

    private static Map<String, Double> getMockTemperatures() {
        Map<String, Double> temperaturesMap = new HashMap<>();

        // dummy data
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);

        return temperaturesMap;
    }
}

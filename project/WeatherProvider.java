package lesson8.project;

import lesson8.project.enums.Periods;
import lesson8.project.entity.WeatherData;

import java.io.IOException;
import java.util.ArrayList;

public interface WeatherProvider {

    WeatherData getWeather(Periods periods) throws IOException;

    WeatherData getAllFromDb() throws IOException;


}
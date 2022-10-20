package lesson8.project;

import com.fasterxml.jackson.core.JsonProcessingException;
import lesson8.project.entity.WeatherData;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseRepositorySQLitelmpl implements DatabaseRepository {


    String filename = null;
    String createTableQuery = "CREATE TABLE IF NOT EXISTS weather (\n" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "city TEXT NOT NULL,\n" +
            "date_time TEXT NOT NULL,\n" +
            "weather_text TEXT NOT NULL,\n" +
            "temperature REAL NOT NULL,\n" +
            ");";
    String insertWeatherQuery = "INSERT INTO weather (city, date_time, weather_text, temperature) VALUES (?,?,?,?)";

    public DatabaseRepositorySQLitelmpl() {
        filename = ApplicationGlobalState.getInstance().getDbFileName();
    }

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + filename);
        return connection;

    }

    private void createTableIfNotExists() {
        try (Connection connection = getConnection()) {
            connection.createStatement().execute(createTableQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean saveWeatherData(WeatherData weatherData) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement saveWeather = connection.prepareStatement(insertWeatherQuery)) {
            saveWeather.setString(1, weatherData.getCity());
            saveWeather.setString(2, weatherData.getLocalDate());
            saveWeather.setString(3, weatherData.getText());
            saveWeather.setDouble(4, weatherData.getTemperature());
            return saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Failure on saving weather object");
    }

    @Override
    public List<WeatherData> getAllSavedData() throws IOException, SQLException {
        Connection connection = getConnection();
        Statement statement;
        statement = connection.createStatement();
        String sql = "SELECT * FROM weather";
        ResultSet resultSet;
        resultSet = statement.executeQuery(sql);
        ArrayList<WeatherData> weatherDataList = new ArrayList<>();
        while (resultSet.next()) {
            WeatherData weatherData = new WeatherData(resultSet.getInt("id"), resultSet.getString("city"),
                    resultSet.getString("localDate"), resultSet.getString("text"), resultSet.getDouble("temperature"));
            weatherDataList.add(weatherData);
        }
        return weatherDataList;
    }
}










//  throw new IOException  ("Not implemented exception");
//  @Override
    /*public List<WeatherData> getAllSavedData() throws IOException {
        throw new IOException("Not implemented exception");
    }*/


  /*        //  ResultSet resultSet =  ("SELECT * FROM students");
            ResultSet resultSet = ("SELECT * FROM weather");
            // В данном случае result set выгружает всю результирующую выборку
            ArrayList<WeatherData> arrayList = new ArrayList<>();
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getInt(1) + " - " +
                                resultSet.getString(2) + " - " +
                                resultSet.getString(3) + " - " +
                                resultSet.getString(4) + " - " +
                                resultSet.getDouble(5) + " - "

                );
            arrayList.add(new Demo.MyClass(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble("score")));
        }*/




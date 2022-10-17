package lesson7.project;
import com.fasterxml.jackson.databind.ObjectMapper;
import lesson6.Example;
import java.time.LocalDate;
import lesson7.project.enums.Periods;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class AccuWeatherProvider implements WeatherProvider {
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST_ENDPOINT = "forecasts";
    private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
    private static final String API_VERSION = "v1";
    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();
    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void getWeather(Periods periods) throws IOException {
        String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();
        String cityKey = detectCityKey();
        if (periods.equals(Periods.NOW)) {
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
            System.out.println();

            ObjectMapper mapper = new ObjectMapper();
            List<JsonObject> exampleObjects = new ArrayList<>();
            JsonObject exampleObject1 = new JsonObject(LocalDate.now(), "Partly sunny", "\"Value\":6.7,\"Unit\":\"C\".");

            exampleObjects.add(exampleObject1);
            WeatherResponse example = new WeatherResponse(exampleObjects);
            String json = mapper.writeValueAsString(example);
            System.out.println("В городе " + selectedCity + exampleObject1);

            // TODO: Сделать в рамках д/з вывод более приятным для пользователя.
            //  Создать класс WeatherResponse, десериализовать ответ сервера в экземпляр класса
            //  Вывести пользователю только текущую температуру в C и сообщение (weather text)
        } else if(periods.equals(Periods.FIVE_DAYS)){
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(FORECAST_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment("daily")
                    .addPathSegment("5day")
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .build();

            // При необходимости указать заголовки
            Request requesthttp = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            String jsonResponse = client.newCall(requesthttp).execute().body().string();
            System.out.println(jsonResponse);
            ObjectMapper mapper = new ObjectMapper();
            StringReader reader = new StringReader(jsonResponse);

            Example example = mapper.readValue(reader, Example.class);
            System.out.println();

            ObjectMapper mapper2 = new ObjectMapper();
            List<JsonObject> exampleObjects = new ArrayList<>();
            JsonObject exampleObject1 = new JsonObject(LocalDate.now(), "Cloudy", "\"Value\":7.6,\"Unit\":\"C\";");
            JsonObject exampleObject2 = new JsonObject(LocalDate.now().plusDays(1), "Cloudy", "\"Value\":7.3,\"Unit\":\"C\";");
            JsonObject exampleObject3 = new JsonObject(LocalDate.now().plusDays(2), "Cloudy", "\"Value\":7.4,\"Unit\":\"C\";");
            JsonObject exampleObject4 = new JsonObject(LocalDate.now().plusDays(3), "Partly sunny", "\"Value\":8.1,\"Unit\":\"C\";");
            JsonObject exampleObject5 = new JsonObject(LocalDate.now().plusDays(4), "Cloudy", "\"Value\":8.5,\"Unit\":\"C\".");

            exampleObjects.add(exampleObject1);
            exampleObjects.add(exampleObject2);
            exampleObjects.add(exampleObject3);
            exampleObjects.add(exampleObject4);
            exampleObjects.add(exampleObject5);
            WeatherResponse example2 = new WeatherResponse(exampleObjects);
            String json = mapper.writeValueAsString(example2);
            System.out.println("В городе " + selectedCity + exampleObject1 + exampleObject2 + exampleObject3 + exampleObject4 + exampleObject5);
        }
    }
    public class WeatherResponse {
        List<JsonObject> exampleObjects = new ArrayList<>();
        public WeatherResponse(List<JsonObject> exampleObjects) {
            this.exampleObjects = exampleObjects;
        }
        public List<JsonObject> getExampleObjects() {
            return exampleObjects;
        }
        public void setExampleObjects(List<JsonObject> exampleObjects) {
            this.exampleObjects = exampleObjects;
        }
    }
    public String detectCityKey() throws IOException {
        String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();

        HttpUrl detectLocationURL = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment("locations")
                .addPathSegment(API_VERSION)
                .addPathSegment("cities")
                .addPathSegment("autocomplete")
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(detectLocationURL)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Невозможно прочесть информацию о городе. " +
                    "Код ответа сервера = " + response.code() + " тело ответа = " + response.body().string());
        }
        String jsonResponse = response.body().string();
        System.out.println("Произвожу поиск города " + selectedCity);

        if (objectMapper.readTree(jsonResponse).size() > 0) {
            String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
            String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
            System.out.println("Найден город " + cityName + " в стране " + countryName);
        } else throw new IOException("Server returns 0 cities");

        return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
    }

}
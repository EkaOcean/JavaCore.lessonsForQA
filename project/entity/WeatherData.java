package lesson8.project.entity;

public class WeatherData {

    private Integer id;
    private String city;
    private String localDate;
    private String text;
    private Double temperature;

    public WeatherData() {
    }
    public WeatherData(Integer id, String city, String localDate, String text, Double temperature) {
        this. id = id;
        this.city = city;
        this.localDate = localDate;
        this.text = text;
        this.temperature = temperature;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}
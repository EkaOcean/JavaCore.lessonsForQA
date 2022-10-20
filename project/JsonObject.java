package lesson8.project;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@JsonIgnoreProperties(ignoreUnknown = true)

class JsonObject {
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)

    @JsonProperty("LocalObservationDateTime")
    private LocalDate date;

    @JsonProperty("WeatherText")
    private String weather_text;

    @JsonProperty("Temperature")
    private String temperature;

    @JsonIgnore
    @JsonProperty("EpochTime")
    private Integer epochTime;
    @JsonIgnore
    @JsonProperty("WeatherIcon")
    private Integer weatherIcon;
    @JsonIgnore
    @JsonProperty("HasPrecipitation")
    private Boolean hasPrecipitation;

    @JsonIgnore
    @JsonProperty("PrecipitationType")
    private Object precipitationType;
    @JsonIgnore
    @JsonProperty("IsDayTime")
    private Boolean isDayTime;

    @JsonIgnore
    @JsonProperty("MobileLink")
    private String mobileLink;

    @JsonIgnore
    @JsonProperty("Link")
    private String link;

    public JsonObject(LocalDate date, String weather_text, String temperature) {
        this.date = date;
        this.weather_text = weather_text;
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return " на дату " + date +
                " погода " + weather_text + ", температура " + temperature;
    }

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getWeather_text() {
        return weather_text;
    }
    public void setWeather_text(String weatherText) {
        this.weather_text = weatherText;
    }

    public String getTemperature() {
        return temperature;
    }
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
    @JsonIgnore
    public Integer getEpochTime() {
        return epochTime;
    }
    @JsonIgnore
    public void setEpochTime(Integer epochTime) {
        this.epochTime = epochTime;
    }
    @JsonIgnore
    @JsonProperty("WeatherIcon")
    public Integer getWeatherIcon() {
        return weatherIcon;
    }
    @JsonIgnore
    @JsonProperty("WeatherIcon")
    public void setWeatherIcon(Integer weatherIcon) {
        this.weatherIcon = weatherIcon;
    }
    @JsonIgnore
    @JsonProperty("HasPrecipitation")
    public Boolean getHasPrecipitation() {
        return hasPrecipitation;
    }
    @JsonIgnore
    @JsonProperty("HasPrecipitation")
    public void setHasPrecipitation(Boolean hasPrecipitation) {
        this.hasPrecipitation = hasPrecipitation;
    }
    @JsonIgnore
    @JsonProperty("PrecipitationType")
    public Object getPrecipitationType() {
        return precipitationType;
    }
    @JsonIgnore
    @JsonProperty("PrecipitationType")
    public void setPrecipitationType(Object precipitationType) {
        this.precipitationType = precipitationType;
    }
    @JsonIgnore
    @JsonProperty("IsDayTime")
    public Boolean getIsDayTime() {
        return isDayTime;
    }
    @JsonIgnore
    @JsonProperty("IsDayTime")
    public void setIsDayTime(Boolean isDayTime) {
        this.isDayTime = isDayTime;
    }
    @JsonIgnore
    @JsonProperty("MobileLink")
    public String getMobileLink() {
        return mobileLink;
    }
    @JsonIgnore
    @JsonProperty("MobileLink")
    public void setMobileLink(String mobileLink) {
        this.mobileLink = mobileLink;
    }
    @JsonIgnore
    @JsonProperty("Link")
    public String getLink() {
        return link;
    }
    @JsonIgnore
    @JsonProperty("Link")
    public void setLink(String link) {
        this.link = link;
    }
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}

package lesson7.project;

public final class ApplicationGlobalState {

    private static ApplicationGlobalState INSTANCE;
    private String selectedCity = null;
    private final String API_KEY = "0d1tNZJPfzzT3qGokM18FGGxAUpt7hpj";

    // private final String API_KEY = "HBAoYTHBeloWennir9bjrNSNYgoGaCqz";

   // private final String API_KEY = "mA2V9Qqjhb1gCs7lgA6ytzRK3FoAmvZt";

    private ApplicationGlobalState() {
    }

    // Непотокобезопасный код для упрощения
    public static ApplicationGlobalState getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ApplicationGlobalState();
        }

        return INSTANCE;
    }

    public String getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(String selectedCity) {
        this.selectedCity = selectedCity;
    }

    public String getApiKey() {
        return this.API_KEY;
    }
}

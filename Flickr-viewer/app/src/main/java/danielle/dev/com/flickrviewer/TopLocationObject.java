package danielle.dev.com.flickrviewer;

public class TopLocationObject {

    private String cityName;
    private String countryName;
    private Integer flagResource;

    public String getCityName() {
        return cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public Integer getFlagResource() {
        return flagResource;
    }

    public TopLocationObject(String cityName, String countryName,
                             Integer flagResource) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.flagResource = flagResource;
    }
}

package danielle.dev.com.flickrviewer;

public class CityLocation {

    private String city;
    private String country;
    private Integer flag;

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Integer getFlag() {
        return flag;
    }

    public CityLocation(String city, String country, Integer flag) {
        this.city = city;
        this.country = country;
        this.flag = flag;
    }
}

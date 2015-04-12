package danielle.dev.com.flickrviewer;

import android.os.Parcelable;

import java.io.Serializable;

public class TopLocationObject implements Serializable {

    private String city;
    private String country;
    private Integer flag;

    private String color;
    private Integer weatherPicture;
    private Integer minTemp;
    private Integer maxTemp;


    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Integer getFlag() {
        return flag;
    }

    public String getColor() {
        return color;
    }

    public Integer getWeatherPicture() {
        return weatherPicture;
    }

    public Integer getMinTemp() {
        return minTemp;
    }

    public Integer getMaxTemp() {
        return maxTemp;
    }

    public String getMinMax()
    {
        return Integer.toString(minTemp) + "\u2103 / " +Integer.toString(maxTemp) + "\u2103";
    }



    public TopLocationObject(String city, String country, Integer flag, String color,
                             Integer weatherPicture, Integer minTemp, Integer maxTemp) {
        this.city = city;
        this.country = country;
        this.flag = flag;
        this.color = color;
        this.weatherPicture = weatherPicture;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }
}

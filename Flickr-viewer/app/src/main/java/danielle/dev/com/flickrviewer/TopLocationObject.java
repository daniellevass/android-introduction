package danielle.dev.com.flickrviewer;

import android.os.Parcelable;

import java.io.Serializable;

public class TopLocationObject implements Serializable {

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

    public TopLocationObject(String city, String country, Integer flag) {
        this.city = city;
        this.country = country;
        this.flag = flag;
    }
}

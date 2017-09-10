package cab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shumishra on 8/6/17.
 */
public class City {
    private String cityName;
    private String cityId;
    private List<Cab> cabs = new ArrayList<>();

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public List<Cab> getCabs() {
        return cabs;
    }

    public void setCabs(List<Cab> cabs) {
        this.cabs = cabs;
    }
}

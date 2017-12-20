package swiggy;

public class DistanceUtil {
    static public int getDistance(Location a, Location b) {
        double diff_x = a.lat - b.lat;
        diff_x = diff_x*diff_x;
        double diff_y = a.lon - b.lon;
        diff_y = diff_y*diff_y;

        return (int) Math.sqrt(diff_x + diff_y);
    }
}

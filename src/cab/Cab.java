package cab;

public class Cab {

    private String cabID;

    private int trips;

    public int getTrips() {
        return trips;
    }

    public void setTrips(int trips) {
        this.trips = trips;
    }

    public String getCabID() {
        return cabID;
    }

    public void setCabID(String cabID) {
        this.cabID = cabID;
    }

    private String status;
    private long last_booked;
    private City city;
    private String cityID;

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public long getLast_booked() {
        return last_booked;
    }

    public void setLast_booked(long last_booked) {
        this.last_booked = last_booked;
    }

    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void changeCurrentCity(Cab cab, City newCity) {
        cab.setCity(newCity);
    }

    public void flipState(Cab cab){
        if(status.equalsIgnoreCase("IDLE")) {
            cab.setStatus("ON_TRIP");
        }
        else {
            cab.setStatus("IDLE");
        }
    }

}

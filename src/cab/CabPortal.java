package cab;

import java.util.*;

/**
 * Created by shumishra on 8/6/17.
 */
public class CabPortal {
    Map<String, City> cities = new HashMap<>();
    Map<String, Cab> cabs = new HashMap<>();
    List<Trip> trips = new ArrayList<>();
    Map<String, Trip> tripsMap= new HashMap<>();

    public void onBoardCity(City newCity){
        cities.put(newCity.getCityId(), newCity);
    }

    public void  registerCab(Cab newCab) {
        if(cities.containsKey(newCab.getCityID())) {
            cabs.put(newCab.getCabID(), newCab);
            cities.get(newCab.getCityID()).getCabs().add(newCab);
        }
        else {
            City city = new City();
            city.setCityId(newCab.getCityID());
            city.getCabs().add(newCab);
            cities.put(newCab.getCityID(), city);
            cabs.put(newCab.getCabID(), newCab);
        }
    }


    public void bookCab(String originID, String destinationID, int strategy){
        if(cities.containsKey(originID) && cities.containsKey(destinationID)) {
            City city = cities.get(originID);
            List<Cab> allcabs = city.getCabs();
            Cab cab = null;
            if(strategy == 1) {
                cab = findCabWithMostIdleTime(allcabs);
            }
            else {
                cab = findCabWithLeastTrips(allcabs);
            }
            if(cab != null) {
                Trip trip = doBooking(cab, originID, destinationID);
                System.out.println(" BOOKING DONE");
                System.out.println(trip.toString());
                trips.add(trip);
                tripsMap.put(trip.getTripId(), trip);
            }
            else
            {
                System.out.println(" NO CABS AVAILABLE");
            }
        }
    }


    private void endTrip(String tripId){
        Trip trip = tripsMap.get(tripId);
        trip.setCompleted(true);
        Cab cab = trip.getCab();
        cab.flipState(trip.getCab());
        cab.setTrips(cab.getTrips()+1);
        cab.setCityID(trip.getDestination());

        System.out.println("Successfully Ended Trip");
        System.out.println(cab.getStatus());
    }

    private void printState(){

    }


    private Trip doBooking(Cab cab, String originID, String destinationID) {
        cab.setLast_booked(new Date().getTime());
        cab.setTrips(cab.getTrips() + 1);
        cab.setStatus("ON_TRIP");
        Trip trip = new Trip();
        trip.setCab(cab);
        trip.setOrigin(originID);
        trip.setDestination(destinationID);
        trip.setTripId(cab.getCabID() + originID + destinationID);
        trip.setCompleted(false);

        return trip;
    }

    private Cab findCabWithLeastTrips(List<Cab> allcabs) {

        Cab ans = null;
        int minTrips = Integer.MAX_VALUE;

        for (Cab cab : allcabs) {
            if(cab.getTrips() < minTrips) {
                minTrips = cab.getTrips();
                ans = cab;
            }
        }
        return ans;
    }

    private Cab findCabWithMostIdleTime(List<Cab> allCabs) {
        Cab ans = null;
        long minLastBooked = Long.MAX_VALUE;

        for (Cab cab : allCabs) {
            if(cab.getLast_booked() < minLastBooked) {
                minLastBooked = cab.getLast_booked();
                ans = cab;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        CabPortal flipKartCab = initialize();

        System.out.println(" -----------");
        System.out.println("Testing Onboard");
        System.out.println(flipKartCab.cities.size());
        City newCity = new City();
        newCity.setCityId("Del");
        newCity.setCityName("Delhi");
        newCity.setCabs(new ArrayList<>());
        flipKartCab.onBoardCity(newCity);

        System.out.println(flipKartCab.cities.size());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(flipKartCab.cabs.size());

        System.out.println(" -----------");
        System.out.println("Testing Registering a new Cab");
        Cab cab = new Cab();
        cab.setStatus("IDLE");
        cab.setCityID("BOM");
        flipKartCab.registerCab(cab);
        System.out.println(flipKartCab.cabs.size());
        System.out.println("registration done");




        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" -----------");
        System.out.println("Testing Booking a Cab");
        String originID = "city_2";
        String destID = "city_3";

        flipKartCab.bookCab(originID,destID, 1);


        System.out.println("working");

    }


    public static CabPortal initialize() {
        CabPortal flipKartCab = new CabPortal();
        int citiesNumber = 4;

        int cabsNumber = 10;

        for(int i=0; i<citiesNumber; i++) {
            City city = new City();
            city.setCityName("cityName"+ (i+1));
            city.setCityId("city_"+ (i+1));
            flipKartCab.cities.put("city_"+ (i+1), city);
        }

        for (int i=0; i<cabsNumber; i++) {
            Cab cab = new Cab();
            Random rand = new Random();
            int  randomCity = rand.nextInt(citiesNumber);
            cab.setCityID(("city_" + randomCity));
            Date date = new Date();
            cab.setLast_booked(date.getTime() - (rand.nextInt(100) + 1)*3600);
            cab.setStatus("IDLE");
            cab.setTrips(rand.nextInt(10));
            cab.setCabID("cab" + (i + 1));
            flipKartCab.cabs.put("cab" + (i + 1) , cab);
            flipKartCab.registerCab(cab);

        }
        return flipKartCab;
    }

  }

package swiggy;

public class Order implements Comparable {
    Location restaurant_location;
    long ordered_time;
    String id;
    boolean assigned = false;


    @Override
    public int compareTo(Object o) {
        return (int) (this.ordered_time - ((Order) o).ordered_time);
    }
}

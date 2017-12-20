package swiggy;

public class DE extends  Person implements Comparable{
    Location current_location;
    int last_order_delivered_time;
    boolean onDelivery = false;

    @Override
    public int compareTo(Object o) {
        return last_order_delivered_time - ((DE) o).last_order_delivered_time;
    }
}

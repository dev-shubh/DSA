package swiggy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Swiggy {

    static Swiggy swiggyInstance;

    Collection orders;
    Collection des;

    //Making Swiggy as Singleton.
    private Swiggy() {
        this.orders = new ArrayList<Order>();
        this.des = new ArrayList<DE>();
    }

    static synchronized Swiggy getSwiggyInstance(){
        if(swiggyInstance == null) {
            swiggyInstance = new Swiggy();
        }
        return swiggyInstance;
    }


    synchronized void addOrder(Order order){
        orders.add(order);
    }

    synchronized void addDe(DE de) {
        des.add(de);
    }

    synchronized List<Assignment> assignOrderToDE(IAssignmentStrategy strategy) {
        return strategy.assign(orders, des);
    }


}

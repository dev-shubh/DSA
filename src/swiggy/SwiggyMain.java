package swiggy;

import java.util.List;

public class SwiggyMain {

    public static void main(String[] args) {

        Swiggy swiggy = Swiggy.getSwiggyInstance();
        AssignmentStrategyFactory assignmentStrategyFactory = AssignmentStrategyFactory.getAssignmentStrategyFactory();

        swiggy.addDe(createNewDE("567", 5, 5, 150));
        swiggy.addDe(createNewDE("765", 7, 7, 100));
        swiggy.addDe(createNewDE("766", 9, 9, 200));

        swiggy.addOrder(createNewOrder(1,1, 50, "123"));
        swiggy.addOrder(createNewOrder(3,3, 30, "145"));

        IAssignmentStrategy strategy = assignmentStrategyFactory.getAssignmentStrategy(0);

        List<Assignment> assignments = swiggy.assignOrderToDE(strategy);

        assignments.forEach( assignment -> {
            System.out.println(" order_id :" + assignment.order_id + "  de_id : " + assignment.de_id );
        });
    }

    static Order createNewOrder(int lat, int lon, int time, String id) {
        Location location = new Location();
        location.lat = lat;location.lon = lon;
        Order order = new Order();
        order.id = id; order.restaurant_location = location; order.ordered_time = time;
        return order;
    }

    static DE createNewDE(String id, int lat, int lon, int time) {
        Location location = new Location();
        location.lat = lat;location.lon = lon;
        DE de = new DE();
        de.id = id; de.current_location = location; de.last_order_delivered_time = time;
        return de;
    }

}

package swiggy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CumulativeStrategy implements IAssignmentStrategy {

    class DistanceHelper implements Comparable{
        String id;
        int distance;

        @Override
        public int compareTo(Object o) {
            return distance - ((DistanceHelper) o).distance;
        }
    }

    @Override
    public synchronized List<Assignment> assign(Collection<Order> orders, Collection<DE> des) {
        Collections.sort((List<Order>) orders);
        Collections.sort((List<DE>) des);
        List<Assignment> assignments = new ArrayList<>();

        for(int i=0; i<orders.size(); i++) {
            if(!((List<Order>) orders).get(i).assigned) {
                List<DistanceHelper> freeDEs = new ArrayList<>();
                for(int j=0; j<des.size(); j++) {
                    if(!((List<DE>) des).get(j).onDelivery) {
                        int distanceFromRest = DistanceUtil.getDistance(((List<Order>) orders).get(i).restaurant_location, ((List<DE>) des).get(j).current_location);
                        DistanceHelper distanceHelper = new DistanceHelper();
                        distanceHelper.distance = distanceFromRest;
                        distanceHelper.id = ((List<DE>) des).get(j).id;
                        freeDEs.add(distanceHelper);
                    }
                }
                Collections.sort(freeDEs);
                if(freeDEs.size() > 0) {
                    Assignment assignment = new Assignment();
                    assignment.de_id = freeDEs.get(0).id;
                    assignment.order_id = ((List<Order>) orders).get(i).id;
                    for(int k=0; k<des.size(); k++) {
                        if(((List<DE>) des).get(k).id == assignment.de_id ) {
                            ((List<DE>) des).get(k).onDelivery = true;
                            break;
                        }
                    }
                    ((List<Order>) orders).get(i).assigned = true;
                    assignments.add(assignment);
                }
            }
        }

        return assignments;
    }
}

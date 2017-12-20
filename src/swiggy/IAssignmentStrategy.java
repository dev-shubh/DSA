package swiggy;

import java.util.Collection;
import java.util.List;

public interface IAssignmentStrategy {
    List<Assignment> assign(Collection<Order> orders, Collection<DE> des);
}

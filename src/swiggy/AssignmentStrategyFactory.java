package swiggy;

public class AssignmentStrategyFactory {

    static AssignmentStrategyFactory assignmentStrategyFactory = new AssignmentStrategyFactory();

    //Making AssignmentStrategyFactory as Singleton.
    private AssignmentStrategyFactory(){}

    static AssignmentStrategyFactory getAssignmentStrategyFactory() {
        return assignmentStrategyFactory;
    }

    IAssignmentStrategy getAssignmentStrategy(int strategyID){
        IAssignmentStrategy strategy = null;
        if(strategyID == 0) {
            strategy = new CumulativeStrategy();
        }
        else if (strategyID == 1) {
            strategy = new MaxUtilDEStrategy();
        }
        else if (strategyID == 2) {
            strategy = new MinOrderDelayStrategy();
        }
        return strategy;
    }
}

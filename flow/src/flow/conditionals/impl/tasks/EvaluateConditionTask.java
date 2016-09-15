package flow.conditionals.impl.tasks;

import flow.CoreFlowObject;
import flow.CoreFlowTask;
import flow.conditional.Condition;

public class EvaluateConditionTask extends CoreFlowObject implements CoreFlowTask
{
    public static boolean run(Condition condition)
    {
        return condition.getCondition();
    }
}
package core.flow.services.conditionals.impl.tasks;

import core.flow.CoreFlowObject;
import core.flow.CoreFlowTask;
import core.flow.conditional.Condition;

public class EvaluateConditionTask extends CoreFlowObject implements CoreFlowTask
{
    public static boolean run(Condition condition)
    {
        return condition.getCondition();
    }
}
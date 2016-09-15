package flow.conditionals.impl.tasks;

import core.utilities.collections.impl.CoreCollectionsServiceImpl;
import flow.CoreFlowObject;
import flow.CoreFlowTask;
import flow.conditional.Condition;
import flow.conditional.IfStatement;

public class EvaluateIfStatementTask extends CoreFlowObject implements CoreFlowTask
{
    public static boolean run(IfStatement ifStatement)
    {
        boolean conditionsEvaluation = false;

        if(ifStatement.getConditions() != null
               && new CoreCollectionsServiceImpl().isCollectionNotEmpty(ifStatement.getConditions().getConditions()))
        {
            int index = 0;

            for(Condition condition : ifStatement.getConditions().getConditions())
            {
                if(index == 0)
                {
                    conditionsEvaluation = EvaluateConditionTask.run(condition);
                }
                else
                {
                    conditionsEvaluation = conditionsEvaluation && EvaluateConditionTask.run(condition);
                }

                ++index;
            }
        }

        return conditionsEvaluation;
    }
}
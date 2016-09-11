package flow.services.conditionals.impl.tasks;

import core.utilities.services.collections.CoreCollectionsService;
import core.utilities.services.collections.impl.CoreCollectionsServiceImpl;
import flow.CoreFlowObject;
import flow.CoreFlowTask;
import flow.conditional.Condition;
import flow.conditional.IfStatement;

public class EvaluateIfStatementTask extends CoreFlowObject implements CoreFlowTask
{
    public boolean run(IfStatement ifStatement)
    {
        boolean conditionsEvaluation = false;

        if(ifStatement.getConditions() != null
               && new CoreCollectionsServiceImpl().isCollectionNotEmpty(ifStatement.getConditions().getConditions()))
        {
            int index = 0;
            EvaluateConditionTask evaluateConditionTask = new EvaluateConditionTask();

            for(Condition condition : ifStatement.getConditions().getConditions())
            {
                if(index == 0)
                {
                    conditionsEvaluation = evaluateConditionTask.run(condition);
                }
                else
                {
                    conditionsEvaluation = conditionsEvaluation && evaluateConditionTask.run(condition);
                }

                ++index;
            }
        }

        return conditionsEvaluation;
    }
}
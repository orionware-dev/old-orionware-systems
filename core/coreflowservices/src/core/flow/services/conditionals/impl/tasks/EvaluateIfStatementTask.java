package core.flow.services.conditionals.impl.tasks;

import core.flow.CoreFlowObject;
import core.flow.CoreFlowTask;
import core.flow.conditional.Condition;
import core.flow.conditional.IfStatement;

public class EvaluateIfStatementTask extends CoreFlowObject implements CoreFlowTask
{
    public static boolean run(IfStatement ifStatement)
    {
        boolean conditionsEvaluation = false;

        if(ifStatement.getConditions() != null && ifStatement.getConditions().getConditions() != null && !ifStatement.getConditions().getConditions().isEmpty())
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
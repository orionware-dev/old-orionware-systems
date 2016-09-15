package flow.conditionals.impl;

import flow.CoreFlowServiceObject;
import flow.conditional.Condition;
import flow.conditional.IfStatement;
import flow.conditionals.ConditionalService;
import flow.conditionals.impl.tasks.EvaluateConditionTask;
import flow.conditionals.impl.tasks.EvaluateIfStatementTask;

public class ConditionalServiceImpl extends CoreFlowServiceObject implements ConditionalService
{
    @Override
    public boolean evaluateCondition(Condition condition)
    {
        return EvaluateConditionTask.run(condition);
    }


    @Override
    public boolean evaluateIfStatement(IfStatement ifStatement)
    {
        return EvaluateIfStatementTask.run(ifStatement);
    }
}
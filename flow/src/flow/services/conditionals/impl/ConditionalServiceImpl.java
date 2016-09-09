package flow.services.conditionals.impl;

import flow.conditional.Condition;
import flow.conditional.IfStatement;
import flow.services.CoreFlowServiceObject;
import flow.services.conditionals.ConditionalService;
import flow.services.conditionals.impl.tasks.EvaluateConditionTask;
import flow.services.conditionals.impl.tasks.EvaluateIfStatementTask;

public class ConditionalServiceImpl extends CoreFlowServiceObject implements ConditionalService
{
    @Override
    public boolean evaluateCondition(Condition condition)
    {
        return new EvaluateConditionTask().run(condition);
    }


    @Override
    public boolean evaluateIfStatement(IfStatement ifStatement)
    {
        return new EvaluateIfStatementTask().run(ifStatement);
    }
}
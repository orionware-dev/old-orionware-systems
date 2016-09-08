package core.flow.services.conditionals.impl;

import core.flow.conditional.Condition;
import core.flow.conditional.IfStatement;
import core.flow.services.CoreFlowServiceObject;
import core.flow.services.conditionals.ConditionalService;
import core.flow.services.conditionals.impl.tasks.EvaluateConditionTask;
import core.flow.services.conditionals.impl.tasks.EvaluateIfStatementTask;

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
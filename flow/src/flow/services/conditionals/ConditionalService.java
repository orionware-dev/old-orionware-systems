package flow.services.conditionals;

import flow.CoreFlowService;
import flow.conditional.Condition;
import flow.conditional.IfStatement;

public interface ConditionalService extends CoreFlowService
{
    public boolean evaluateCondition(Condition condition);


    public boolean evaluateIfStatement(IfStatement ifStatement);
}
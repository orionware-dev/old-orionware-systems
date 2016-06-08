package core.flow.services.conditionals;

import core.flow.CoreFlowService;
import core.flow.conditional.Condition;
import core.flow.conditional.IfStatement;

public interface ConditionalService extends CoreFlowService
{
    public boolean evaluateCondition(Condition condition);
    
    
    public boolean evaluateIfStatement(IfStatement ifStatement);
}
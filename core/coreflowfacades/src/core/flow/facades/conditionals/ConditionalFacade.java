package core.flow.facades.conditionals;

import core.flow.CoreFlowFacade;
import core.flow.conditional.Condition;
import core.flow.conditional.IfStatement;

public interface ConditionalFacade extends CoreFlowFacade
{
    public boolean evaluateCondition(Condition condition);


    public boolean evaluateIfStatement(IfStatement ifStatement);
}
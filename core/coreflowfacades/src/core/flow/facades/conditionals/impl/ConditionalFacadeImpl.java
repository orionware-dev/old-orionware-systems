package core.flow.facades.conditionals.impl;

import core.flow.conditional.Condition;
import core.flow.conditional.IfStatement;
import core.flow.facades.CoreFlowFacadeObject;
import core.flow.facades.conditionals.ConditionalFacade;
import core.flow.services.conditionals.ConditionalService;
import core.flow.services.conditionals.impl.ConditionalServiceImpl;

public class ConditionalFacadeImpl extends CoreFlowFacadeObject implements ConditionalFacade
{
    private ConditionalService conditionalService;
    
    
    public ConditionalFacadeImpl()
    {
        this.conditionalService = new ConditionalServiceImpl();
    }
    
    
    @Override
    public boolean evaluateCondition(Condition condition)
    {
        return conditionalService.evaluateCondition(condition);
    }

    
    @Override
    public boolean evaluateIfStatement(IfStatement ifStatement)
    {
        return conditionalService.evaluateIfStatement(ifStatement);
    }
}
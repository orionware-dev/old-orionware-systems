package core.flow.conditional;

import core.flow.CoreFlowObject;

public class IfStatement extends CoreFlowObject
{
    private Conditions conditions;
    
    
    public IfStatement(Conditions conditions)
    {
        setConditions(conditions);
    }
    
    
    public boolean evaluateConditions()
    {
        boolean conditionsEvaluation = false;
        
        if(getConditions() != null && getConditions().getConditions() != null && !getConditions().getConditions().isEmpty())
        {
            int index = 0;
            
            for(Condition condition : getConditions().getConditions())
            {
                if(index == 0)
                {
                    conditionsEvaluation = condition.getCondition();
                }
                else
                {
                    conditionsEvaluation = conditionsEvaluation && condition.getCondition();
                }
                
                ++index;
            }
        }
        
        return conditionsEvaluation;
    }


    public Conditions getConditions()
    {
        return this.conditions;
    }


    public void setConditions(Conditions conditions)
    {
        this.conditions = conditions;
    }
}
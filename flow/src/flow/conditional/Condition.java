package flow.conditional;

import flow.CoreFlowObject;

public class Condition extends CoreFlowObject
{
    private boolean condition;


    public Condition(boolean condition)
    {
        setCondition(condition);
    }


    public boolean getCondition()
    {
        return this.condition;
    }


    public void setCondition(boolean condition)
    {
        this.condition = condition;
    }
}
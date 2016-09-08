package core.flow.conditional;

import core.flow.CoreFlowObject;

public class IfStatement extends CoreFlowObject
{
    private Conditions conditions;


    public IfStatement(Conditions conditions)
    {
        setConditions(conditions);
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
package core.flow.conditional;

import java.util.ArrayList;
import java.util.List;
import core.flow.CoreFlowObject;

public class Conditions extends CoreFlowObject
{
    private List<Condition> conditions;
    
    
    public Conditions()
    {
        setConditions(new ArrayList<Condition>());
    }
    
    
    public Conditions(List<Condition> conditions)
    {
        setConditions(conditions);
    }
    
    
    public void addCondition(Condition condition)
    {
        getConditions().add(condition);
    }


    public List<Condition> getConditions()
    {
        return this.conditions;
    }


    public void setConditions(List<Condition> conditions)
    {
        this.conditions = conditions;
    }
}
package core;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class OrionSimpleObject implements Consumer
{
    private List<Object> actionSequence;
    
    
    protected void first(Object object)
    {
        this.actionSequence = new ArrayList<Object>();
        actionSequence.add(object);
    }
    
    
    protected void then(Consumer<?> method)
    {
        if(actionSequence == null || actionSequence.isEmpty())
        {
            first(method);
        }
        else
        {
            actionSequence.add(method.andThen(after));
        }
    }
}
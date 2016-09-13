package reflection.instancevariables.access.impl.tasks;

import java.lang.reflect.Field;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class MakeInstanceVariableAccessibleTask extends ReflectionObject implements ReflectionTask
{
    private Field instanceVariable;


    public void run(Field instanceVariable)
    {
        this.instanceVariable = instanceVariable;

        if(instanceVariableIsNotAccessible())
        {
            makeInstanceVariableAccessible();
        }
    }


    private boolean instanceVariableIsNotAccessible()
    {
        return !instanceVariable.isAccessible();
    }


    private void makeInstanceVariableAccessible()
    {
        instanceVariable.setAccessible(true);
    }
}
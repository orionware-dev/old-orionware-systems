package reflection.services.loader.impl.tasks;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
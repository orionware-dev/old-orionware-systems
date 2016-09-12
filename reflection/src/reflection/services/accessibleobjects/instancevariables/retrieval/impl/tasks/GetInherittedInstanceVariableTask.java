package reflection.services.accessibleobjects.instancevariables.retrieval.impl.tasks;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetInherittedInstanceVariableTask extends ReflectionObject implements ReflectionTask
{
    public Field run(String instanceVariableName, Object object)
    {
        return run(instanceVariableName, object.getClass());
    }


    public Field run(String instanceVariableName, Class<?> aClass)
    {
        Field inherittedInstanceVariable = null;

        try
        {
            Field publicOrInherittedInstanceVariable = aClass.getField(instanceVariableName);
            Field declaredInstanceVariable = new GetDeclaredInstanceVariableTask().run(instanceVariableName, aClass);

            if(declaredInstanceVariable == null || !Modifier.isPublic(declaredInstanceVariable.getModifiers()))
            {
                inherittedInstanceVariable = publicOrInherittedInstanceVariable;
            }
        }
        catch(NoSuchFieldException exception)
        {
            exception.printStackTrace();
        }
        catch(SecurityException exception)
        {
            exception.printStackTrace();
        }

        return inherittedInstanceVariable;
    }
}
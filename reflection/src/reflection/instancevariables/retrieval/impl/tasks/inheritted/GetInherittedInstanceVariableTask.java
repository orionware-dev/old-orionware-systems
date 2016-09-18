package reflection.instancevariables.retrieval.impl.tasks.inheritted;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import reflection.ReflectionObject;
import reflection.ReflectionTask;
import reflection.instancevariables.retrieval.impl.tasks.declared.GetDeclaredInstanceVariableTask;

public class GetInherittedInstanceVariableTask extends ReflectionObject implements ReflectionTask
{
    public static Field run(String instanceVariableName, Object object)
    {
        return run(instanceVariableName, object.getClass());
    }


    public static Field run(String instanceVariableName, Class<?> aClass)
    {
        Field inherittedInstanceVariable = null;

        try
        {
            Field publicOrInherittedInstanceVariable = aClass.getField(instanceVariableName);
            Field declaredInstanceVariable = GetDeclaredInstanceVariableTask.run(instanceVariableName, aClass);

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
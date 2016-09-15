package reflection.instancevariables.retrieval.impl.tasks;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetDeclaredProtectedInstanceVariablesArrayTask extends ReflectionObject implements ReflectionTask
{
    public Field[] run(Class<?> aClass)
    {
        List<Field> declaredProtectedInstanceVariables = new ArrayList<Field>();
        
        for(Field instanceVariable : aClass.getDeclaredFields())
        {
            if(Modifier.isProtected(instanceVariable.getModifiers()))
            {
                declaredProtectedInstanceVariables.add(instanceVariable);
            }
        }
        
        return declaredProtectedInstanceVariables.toArray(new Field[0]);
    }


    public Field[] run(Object object)
    {
        return run(object.getClass());
    }
}
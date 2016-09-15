package reflection.instancevariables.retrieval.impl.tasks;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetDeclaredPublicInstanceVariablesArrayTask extends ReflectionObject implements ReflectionTask
{
    public Field[] run(Class<?> aClass)
    {
        List<Field> declaredPublicInstanceVariables = new ArrayList<Field>();
        
        for(Field instanceVariable : aClass.getDeclaredFields())
        {
            if(Modifier.isPublic(instanceVariable.getModifiers()))
            {
                declaredPublicInstanceVariables.add(instanceVariable);
            }
        }
        
        return declaredPublicInstanceVariables.toArray(new Field[0]);
    }


    public Field[] run(Object object)
    {
        return run(object.getClass());
    }
}
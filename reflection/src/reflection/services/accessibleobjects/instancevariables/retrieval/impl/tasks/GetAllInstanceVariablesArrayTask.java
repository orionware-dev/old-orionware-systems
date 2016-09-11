package reflection.services.accessibleobjects.instancevariables.retrieval.impl.tasks;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetAllInstanceVariablesArrayTask extends ReflectionObject implements ReflectionTask
{
    public Method[] run(Class<?> aClass)
    {
        List<Method> inherittedMethods = Arrays.asList(new GetInherittedInstanceVariablesArrayTask().run(aClass));
        List<Method> declaredMethods = Arrays.asList(new GetDeclaredInstanceVariablesArrayTask().run(aClass));
        declaredMethods.addAll(inherittedMethods);
        return declaredMethods.toArray(new Method[0]);
    }
    
    
    public Method[] run(Object object)
    {
        return run(object.getClass());
    }
}
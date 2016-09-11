package reflection.services.accessibleobjects.methods.retrieval.impl.tasks;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetAllMethodsArrayTask extends ReflectionObject implements ReflectionTask
{
    public Method[] run(Class<?> aClass)
    {
        List<Method> inherittedMethods = Arrays.asList(new GetInherittedMethodsArrayTask().run(aClass));
        List<Method> declaredMethods = Arrays.asList(new GetDeclaredMethodsArrayTask().run(aClass));
        declaredMethods.addAll(inherittedMethods);
        return declaredMethods.toArray(new Method[0]);
    }
    
    
    public Method[] run(Object object)
    {
        return run(object.getClass());
    }
}
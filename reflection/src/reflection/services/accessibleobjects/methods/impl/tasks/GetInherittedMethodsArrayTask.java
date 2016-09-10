package reflection.services.accessibleobjects.methods.impl.tasks;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetInherittedMethodsArrayTask extends ReflectionObject implements ReflectionTask
{
    public Method[] run(Class<?> aClass)
    {
        List<Method> allMethods = Arrays.asList(aClass.getMethods());
        List<Method> declaredMethods = Arrays.asList(aClass.getDeclaredMethods());
        //these are the inheritted methods only
        allMethods.removeAll(declaredMethods);
        return allMethods.toArray(new Method[0]);
    }
    
    
    public Method[] run(Object object)
    {
        return run(object.getClass());
    }
}
package reflection.methods.retrieval.impl.tasks;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetInherittedMethodsArrayTask extends ReflectionObject implements ReflectionTask
{
    public static Method[] run(Class<?> aClass)
    {
        List<Method> publicMethods = Arrays.asList(GetDeclaredPublicMethodsArrayTask.run(aClass));
        List<Method> publicAndInherittedMethods = Arrays.asList(aClass.getMethods());
        //these are the inheritted methods only
        publicAndInherittedMethods.removeAll(publicMethods);
        return publicAndInherittedMethods.toArray(new Method[0]);
    }
    
    
    public static Method[] run(Object object)
    {
        return run(object.getClass());
    }
}
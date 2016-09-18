package reflection.methods.retrieval.impl.tasks.privates;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetPrivateMethodsArrayTask extends ReflectionObject implements ReflectionTask
{
    public static Method[] run(Class<?> aClass)
    {
        List<Method> declaredPrivateMethods = new ArrayList<Method>();
        
        for(Method method : aClass.getDeclaredMethods())
        {
            if(Modifier.isPrivate(method.getModifiers()))
            {
                declaredPrivateMethods.add(method);
            }
        }
        
        return declaredPrivateMethods.toArray(new Method[0]);
    }
    
    
    public static Method[] run(Object object)
    {
        return run(object.getClass());
    }
}
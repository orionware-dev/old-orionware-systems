package reflection.methods.retrieval.impl.tasks.declared;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetDeclaredPublicMethodsArrayTask extends ReflectionObject implements ReflectionTask
{
    public static Method[] run(Class<?> aClass)
    {
        List<Method> declaredPublicMethods = new ArrayList<Method>();
        
        for(Method method : aClass.getDeclaredMethods())
        {
            if(Modifier.isPublic(method.getModifiers()))
            {
                declaredPublicMethods.add(method);
            }
        }
        
        return declaredPublicMethods.toArray(new Method[0]);
    }
    
    
    public static Method[] run(Object object)
    {
        return run(object.getClass());
    }
}
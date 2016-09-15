package reflection.methods.retrieval.impl.tasks;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetDeclaredProtectedMethodsArrayTask extends ReflectionObject implements ReflectionTask
{
    public Method[] run(Class<?> aClass)
    {
        List<Method> declaredProtectedMethods = new ArrayList<Method>();
        
        for(Method method : aClass.getDeclaredMethods())
        {
            if(Modifier.isProtected(method.getModifiers()))
            {
                declaredProtectedMethods.add(method);
            }
        }
        
        return declaredProtectedMethods.toArray(new Method[0]);
    }
    
    
    public Method[] run(Object object)
    {
        return run(object.getClass());
    }
}
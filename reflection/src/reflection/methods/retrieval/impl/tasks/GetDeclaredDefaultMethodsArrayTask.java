package reflection.methods.retrieval.impl.tasks;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetDeclaredDefaultMethodsArrayTask extends ReflectionObject implements ReflectionTask
{
    public static Method[] run(Class<?> aClass)
    {
        List<Method> declaredDefaultMethods = new ArrayList<Method>();
        
        for(Method method : aClass.getDeclaredMethods())
        {
            if(!Modifier.isPrivate(method.getModifiers())
                    && !Modifier.isProtected(method.getModifiers())
                    && !Modifier.isPublic(method.getModifiers()))
            {
                declaredDefaultMethods.add(method);
            }
        }
        
        return declaredDefaultMethods.toArray(new Method[0]);
    }
    
    
    public static Method[] run(Object object)
    {
        return run(object.getClass());
    }
}
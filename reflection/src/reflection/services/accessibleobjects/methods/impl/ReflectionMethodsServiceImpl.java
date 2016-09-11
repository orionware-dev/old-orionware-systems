package reflection.services.accessibleobjects.methods.impl;

import java.lang.reflect.Method;
import reflection.services.ReflectionServiceObject;
import reflection.services.accessibleobjects.methods.ReflectionMethodsService;
import reflection.services.accessibleobjects.methods.impl.tasks.GetInherittedMethodsArrayTask;
import reflection.services.accessibleobjects.methods.impl.tasks.GetMethodTask;
import reflection.services.accessibleobjects.methods.impl.tasks.GetMethodsArrayTask;

public class ReflectionMethodsServiceImpl extends ReflectionServiceObject implements ReflectionMethodsService
{
    @Override
    public Method getMethod(String methodName, Object object, Class<?>... methodParameterTypes)
    {
        return new GetMethodTask().run(methodName, object.getClass(), methodParameterTypes);
    }
    
    
    @Override
    public Method getMethod(String methodName, Class<?> aClass, Class<?>... methodParameterTypes)
    {
        return new GetMethodTask().run(methodName, aClass, methodParameterTypes);
    }


    @Override
    public Method[] getMethodsArray(Object object)
    {
        return new GetMethodsArrayTask().run(object);
    }
    
    
    @Override
    public Method[] getMethodsArray(Class<?> aClass)
    {
        return new GetMethodsArrayTask().run(aClass);
    }
    
    
    @Override
    public Method[] getInherittedMethodsArray(Object object)
    {
        return new GetInherittedMethodsArrayTask().run(object);
    }


    @Override
    public Method[] getInherittedMethodsArray(Class<?> aClass)
    {
        return new GetInherittedMethodsArrayTask().run(aClass);
    }
}
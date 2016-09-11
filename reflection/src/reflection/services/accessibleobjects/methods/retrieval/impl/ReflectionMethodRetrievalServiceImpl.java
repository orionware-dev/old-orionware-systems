package reflection.services.accessibleobjects.methods.retrieval.impl;

import java.lang.reflect.Method;
import reflection.services.ReflectionServiceObject;
import reflection.services.accessibleobjects.methods.retrieval.ReflectionMethodRetrievalService;
import reflection.services.accessibleobjects.methods.retrieval.impl.tasks.GetDeclaredMethodTask;
import reflection.services.accessibleobjects.methods.retrieval.impl.tasks.GetInherittedMethodTask;

public class ReflectionMethodRetrievalServiceImpl extends ReflectionServiceObject implements ReflectionMethodRetrievalService
{
    @Override
    public Method getDeclaredMethod(String methodName, Object object, Class<?>... methodParameterTypes)
    {
        return new GetDeclaredMethodTask().run(methodName, object.getClass(), methodParameterTypes);
    }
    
    
    @Override
    public Method getDeclaredMethod(String methodName, Class<?> aClass, Class<?>... methodParameterTypes)
    {
        return new GetDeclaredMethodTask().run(methodName, aClass, methodParameterTypes);
    }
    
    
    @Override
    public Method getPrivateMethod(String methodName, Object object, Class<?>... methodParameterTypes)
    {
        return new GetDeclaredMethodTask().run(methodName, object.getClass(), methodParameterTypes);
    }
    
    
    @Override
    public Method getPrivateMethod(String methodName, Class<?> aClass, Class<?>... methodParameterTypes)
    {
        return new GetDeclaredMethodTask().run(methodName, aClass, methodParameterTypes);
    }


    @Override
    public Method getDeclaredDefaultMethod(String methodName, Object object, Class<?>... methodParameterTypes)
    {
        return new GetDeclaredMethodTask().run(methodName, object.getClass(), methodParameterTypes);
    }


    @Override
    public Method getDeclaredDefaultMethod(String methodName, Class<?> aClass, Class<?>... methodParameterTypes)
    {
        return new GetDeclaredMethodTask().run(methodName, aClass, methodParameterTypes);
    }


    @Override
    public Method getDeclaredPublicMethod(String methodName, Object object, Class<?>... methodParameterTypes)
    {
        return new GetDeclaredMethodTask().run(methodName, object.getClass(), methodParameterTypes);
    }


    @Override
    public Method getDeclaredPublicMethod(String methodName, Class<?> aClass, Class<?>... methodParameterTypes)
    {
        return new GetDeclaredMethodTask().run(methodName, aClass, methodParameterTypes);
    }


    @Override
    public Method getDeclaredProtectedMethod(String methodName, Object object, Class<?>... methodParameterTypes)
    {
        return new GetDeclaredMethodTask().run(methodName, object.getClass(), methodParameterTypes);
    }


    @Override
    public Method getDeclaredProtectedMethod(String methodName, Class<?> aClass, Class<?>... methodParameterTypes)
    {
        return new GetDeclaredMethodTask().run(methodName, aClass, methodParameterTypes);
    }


    @Override
    public Method getInherittedMethod(String methodName, Object object, Class<?>... methodParameterTypes)
    {
        return new GetInherittedMethodTask().run(methodName, object.getClass(), methodParameterTypes);
    }


    @Override
    public Method getInherittedMethod(String methodName, Class<?> aClass, Class<?>... methodParameterTypes)
    {
        return new GetInherittedMethodTask().run(methodName, aClass, methodParameterTypes);
    }
}
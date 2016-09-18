package reflection.methods.retrieval.impl;

import java.lang.reflect.Method;
import reflection.ReflectionServiceObject;
import reflection.methods.retrieval.ReflectionMethodRetrievalService;
import reflection.methods.retrieval.impl.tasks.checks.IsDefaultMethodTask;
import reflection.methods.retrieval.impl.tasks.checks.IsPrivateMethodTask;
import reflection.methods.retrieval.impl.tasks.checks.IsProtectedMethodTask;
import reflection.methods.retrieval.impl.tasks.checks.IsPublicMethodTask;
import reflection.methods.retrieval.impl.tasks.declared.GetDeclaredDefaultMethodTask;
import reflection.methods.retrieval.impl.tasks.declared.GetDeclaredMethodTask;
import reflection.methods.retrieval.impl.tasks.declared.GetDeclaredProtectedMethodTask;
import reflection.methods.retrieval.impl.tasks.declared.GetDeclaredPublicMethodTask;
import reflection.methods.retrieval.impl.tasks.inheritted.GetInherittedMethodTask;
import reflection.methods.retrieval.impl.tasks.privates.GetPrivateMethodTask;

public class ReflectionMethodRetrievalServiceImpl extends ReflectionServiceObject implements ReflectionMethodRetrievalService
{
    @Override
    public Method getDeclaredMethod(String methodName, Object object, Class<?>... methodParameterTypes)
    {
        return GetDeclaredMethodTask.run(methodName, object.getClass(), methodParameterTypes);
    }


    @Override
    public Method getDeclaredMethod(String methodName, Class<?> aClass, Class<?>... methodParameterTypes)
    {
        return GetDeclaredMethodTask.run(methodName, aClass, methodParameterTypes);
    }


    @Override
    public Method getPrivateMethod(String methodName, Object object, Class<?>... methodParameterTypes)
    {
        return GetPrivateMethodTask.run(methodName, object, methodParameterTypes);
    }


    @Override
    public Method getPrivateMethod(String methodName, Class<?> aClass, Class<?>... methodParameterTypes)
    {
        return GetPrivateMethodTask.run(methodName, aClass, methodParameterTypes);
    }


    @Override
    public Method getDeclaredDefaultMethod(String methodName, Object object, Class<?>... methodParameterTypes)
    {
        return GetDeclaredDefaultMethodTask.run(methodName, object, methodParameterTypes);
    }


    @Override
    public Method getDeclaredDefaultMethod(String methodName, Class<?> aClass, Class<?>... methodParameterTypes)
    {
        return GetDeclaredDefaultMethodTask.run(methodName, aClass, methodParameterTypes);
    }


    @Override
    public Method getDeclaredPublicMethod(String methodName, Object object, Class<?>... methodParameterTypes)
    {
        return GetDeclaredPublicMethodTask.run(methodName, object, methodParameterTypes);
    }


    @Override
    public Method getDeclaredPublicMethod(String methodName, Class<?> aClass, Class<?>... methodParameterTypes)
    {
        return GetDeclaredPublicMethodTask.run(methodName, aClass, methodParameterTypes);
    }


    @Override
    public Method getDeclaredProtectedMethod(String methodName, Object object, Class<?>... methodParameterTypes)
    {
        return GetDeclaredProtectedMethodTask.run(methodName, object, methodParameterTypes);
    }


    @Override
    public Method getDeclaredProtectedMethod(String methodName, Class<?> aClass, Class<?>... methodParameterTypes)
    {
        return GetDeclaredProtectedMethodTask.run(methodName, aClass, methodParameterTypes);
    }


    @Override
    public Method getInherittedMethod(String methodName, Object object, Class<?>... methodParameterTypes)
    {
        return GetInherittedMethodTask.run(methodName, object, methodParameterTypes);
    }


    @Override
    public Method getInherittedMethod(String methodName, Class<?> aClass, Class<?>... methodParameterTypes)
    {
        return GetInherittedMethodTask.run(methodName, aClass, methodParameterTypes);
    }


    @Override
    public boolean isDefaultMethod(Method method)
    {
        return IsDefaultMethodTask.run(method);
    }


    @Override
    public boolean isPrivateMethod(Method method)
    {
        return IsPrivateMethodTask.run(method);
    }


    @Override
    public boolean isProtectedMethod(Method method)
    {
        return IsProtectedMethodTask.run(method);
    }


    @Override
    public boolean isPublicMethod(Method method)
    {
        return IsPublicMethodTask.run(method);
    }
}
package reflection.methods.retrieval.impl;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import reflection.ReflectionServiceObject;
import reflection.methods.retrieval.ReflectionMethodsRetrievalService;
import reflection.methods.retrieval.impl.tasks.GetAllMethodsArrayTask;
import reflection.methods.retrieval.impl.tasks.GetDeclaredDefaultMethodsArrayTask;
import reflection.methods.retrieval.impl.tasks.GetDeclaredMethodsArrayTask;
import reflection.methods.retrieval.impl.tasks.GetDeclaredProtectedMethodsArrayTask;
import reflection.methods.retrieval.impl.tasks.GetDeclaredPublicMethodsArrayTask;
import reflection.methods.retrieval.impl.tasks.GetInherittedMethodsArrayTask;
import reflection.methods.retrieval.impl.tasks.GetPrivateMethodsArrayTask;

public class ReflectionMethodsRetrievalServiceImpl extends ReflectionServiceObject implements ReflectionMethodsRetrievalService
{
    @Override
    public Method[] getDeclaredMethodsArray(Object object)
    {
        return GetDeclaredMethodsArrayTask.run(object);
    }


    @Override
    public Method[] getDeclaredMethodsArray(Class<?> aClass)
    {
        return GetDeclaredMethodsArrayTask.run(aClass);
    }


    @Override
    public List<Method> getDeclaredMethods(Object object)
    {
        return Arrays.asList(getDeclaredMethodsArray(object));
    }


    @Override
    public List<Method> getDeclaredMethods(Class<?> aClass)
    {
        return Arrays.asList(getDeclaredMethodsArray(aClass));
    }


    @Override
    public Method[] getDeclaredDefaultMethodsArray(Object object)
    {
        return GetDeclaredDefaultMethodsArrayTask.run(object);
    }


    @Override
    public Method[] getDeclaredDefaultMethodsArray(Class<?> aClass)
    {
        return GetDeclaredDefaultMethodsArrayTask.run(aClass);
    }


    @Override
    public List<Method> getDeclaredDefaultMethods(Object object)
    {
        return Arrays.asList(getDeclaredDefaultMethodsArray(object));
    }


    @Override
    public List<Method> getDeclaredDefaultMethods(Class<?> aClass)
    {
        return Arrays.asList(getDeclaredDefaultMethodsArray(aClass));
    }


    @Override
    public Method[] getPrivateMethodsArray(Object object)
    {
        return GetPrivateMethodsArrayTask.run(object);
    }


    @Override
    public Method[] getPrivateMethodsArray(Class<?> aClass)
    {
        return GetPrivateMethodsArrayTask.run(aClass);
    }


    @Override
    public List<Method> getPrivateMethods(Object object)
    {
        return Arrays.asList(getPrivateMethodsArray(object));
    }


    @Override
    public List<Method> getPrivateMethods(Class<?> aClass)
    {
        return Arrays.asList(getPrivateMethodsArray(aClass));
    }


    @Override
    public Method[] getDeclaredProtectedMethodsArray(Object object)
    {
        return GetDeclaredProtectedMethodsArrayTask.run(object);
    }


    @Override
    public Method[] getDeclaredProtectedMethodsArray(Class<?> aClass)
    {
        return GetDeclaredProtectedMethodsArrayTask.run(aClass);
    }


    @Override
    public List<Method> getDeclaredProtectedMethods(Object object)
    {
        return Arrays.asList(getDeclaredProtectedMethodsArray(object));
    }


    @Override
    public List<Method> getDeclaredProtectedMethods(Class<?> aClass)
    {
        return Arrays.asList(getDeclaredProtectedMethodsArray(aClass));
    }


    @Override
    public Method[] getDeclaredPublicMethodsArray(Object object)
    {
        return GetDeclaredPublicMethodsArrayTask.run(object);
    }


    @Override
    public Method[] getDeclaredPublicMethodsArray(Class<?> aClass)
    {
        return GetDeclaredPublicMethodsArrayTask.run(aClass);
    }


    @Override
    public List<Method> getDeclaredPublicMethods(Object object)
    {
        return Arrays.asList(getDeclaredPublicMethodsArray(object));
    }


    @Override
    public List<Method> getDeclaredPublicMethods(Class<?> aClass)
    {
        return Arrays.asList(getDeclaredPublicMethodsArray(aClass));
    }


    @Override
    public Method[] getInherittedMethodsArray(Object object)
    {
        return GetInherittedMethodsArrayTask.run(object);
    }


    @Override
    public Method[] getInherittedMethodsArray(Class<?> aClass)
    {
        return GetInherittedMethodsArrayTask.run(aClass);
    }


    @Override
    public List<Method> getInherittedMethods(Object object)
    {
        return Arrays.asList(getInherittedMethodsArray(object));
    }


    @Override
    public List<Method> getInherittedMethods(Class<?> aClass)
    {
        return Arrays.asList(getInherittedMethodsArray(aClass));
    }


    @Override
    public Method[] getAllMethodsArray(Object object)
    {
        return GetAllMethodsArrayTask.run(object);
    }


    @Override
    public Method[] getAllMethodsArray(Class<?> aClass)
    {
        return GetAllMethodsArrayTask.run(aClass);
    }


    @Override
    public List<Method> getAllMethods(Object object)
    {
        return Arrays.asList(getAllMethodsArray(object));
    }


    @Override
    public List<Method> getAllMethods(Class<?> aClass)
    {
        return Arrays.asList(getAllMethodsArray(aClass));
    }
}
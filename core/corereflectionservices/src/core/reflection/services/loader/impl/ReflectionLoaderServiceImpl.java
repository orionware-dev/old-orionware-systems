package core.reflection.services.loader.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import core.reflection.services.ReflectionServiceObject;
import core.reflection.services.loader.ReflectionLoaderService;
import core.reflection.services.loader.impl.tasks.CallConstructorTask;
import core.reflection.services.loader.impl.tasks.CallMethodTask;
import core.reflection.services.loader.impl.tasks.GetConstructorsArrayTask;
import core.reflection.services.loader.impl.tasks.GetMethodFromClassTask;
import core.reflection.services.loader.impl.tasks.GetMethodsArrayTask;
import core.reflection.services.loader.impl.tasks.InstantiateClassTask;
import core.reflection.services.loader.impl.tasks.LoadClassTask;
import core.reflection.services.loader.impl.tasks.MakeMethodAccessibleTask;

public class ReflectionLoaderServiceImpl extends ReflectionServiceObject implements ReflectionLoaderService
{
    @Override
    public Method getMethodFromClass(String methodName, Class<?> aClass, Class<?>... methodParameterTypes)
    {
        return new GetMethodFromClassTask().run(methodName, aClass, methodParameterTypes);
    }


    @Override
    public Method[] getMethodsArray(Object object)
    {
        return new GetMethodsArrayTask().run(object);
    }


    @Override
    public Constructor<?>[] getConstructorsArray(Object object)
    {
        return new GetConstructorsArrayTask().run(object);
    }


    @Override
    public void makeMethodAccessible(Method method)
    {
        new MakeMethodAccessibleTask().run(method);
    }


    @Override
    public Object callMethod(Method method, Object objectMethodBelongsTo, Object... methodArguments)
    {
        makeMethodAccessible(method);
        return new CallMethodTask().run(method, objectMethodBelongsTo, methodArguments);
    }


    @Override
    public void callConstructor(Constructor<?> constructor, Object... constructorArguments)
    {
        new CallConstructorTask().run(constructor, constructorArguments);
    }


    @Override
    public Class<?> loadClass(String className)
    {
        return new LoadClassTask().run(className);
    }


    @Override
    public Object instantiateClass(Class<?> classToInstantiate)
    {
        return new InstantiateClassTask().run(classToInstantiate);
    }


    @Override
    public Object loadAndInstantiateClass(String className)
    {
        return instantiateClass(loadClass(className));
    }
}
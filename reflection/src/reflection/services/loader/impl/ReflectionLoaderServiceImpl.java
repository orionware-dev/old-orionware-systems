package reflection.services.loader.impl;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import reflection.services.ReflectionServiceObject;
import reflection.services.loader.ReflectionLoaderService;
import reflection.services.loader.impl.tasks.CallConstructorTask;
import reflection.services.loader.impl.tasks.CallMethodTask;
import reflection.services.loader.impl.tasks.GetAccessibleObjectsArrayTask;
import reflection.services.loader.impl.tasks.GetConstructorsArrayTask;
import reflection.services.loader.impl.tasks.GetInstanceVariablesArrayTask;
import reflection.services.loader.impl.tasks.GetMethodFromClassTask;
import reflection.services.loader.impl.tasks.GetMethodTask;
import reflection.services.loader.impl.tasks.GetMethodsArrayTask;
import reflection.services.loader.impl.tasks.InstantiateClassTask;
import reflection.services.loader.impl.tasks.LoadClassTask;
import reflection.services.loader.impl.tasks.MakeInstanceVariableAccessibleTask;
import reflection.services.loader.impl.tasks.MakeMethodAccessibleTask;

public class ReflectionLoaderServiceImpl extends ReflectionServiceObject implements ReflectionLoaderService
{
    @Override
    public Method getMethodFromClass(String methodName, Class<?> aClass, Class<?>... methodParameterTypes)
    {
        return new GetMethodFromClassTask().run(methodName, aClass, methodParameterTypes);
    }
    
    
    @Override
    public Field[] getInstanceVariablesArray(Object object)
    {
        return new GetInstanceVariablesArrayTask().run(object);
    }
    
    
    @Override
    public Field[] getInstanceVariablesArray(Class<?> aClass)
    {
        return new GetInstanceVariablesArrayTask().run(aClass);
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
    public Constructor<?>[] getConstructorsArray(Object object)
    {
        return new GetConstructorsArrayTask().run(object);
    }
    
    
    @Override
    public Constructor<?>[] getConstructorsArray(Class<?> aClass)
    {
        return new GetConstructorsArrayTask().run(aClass);
    }
    
    
    @Override
    public AccessibleObject[] getAccessibleObjectsArray(Class<?> aClass)
    {
        return new GetAccessibleObjectsArrayTask().run(aClass);
    }
    
    
    @Override
    public AccessibleObject[] getAccessibleObjectsArray(Object object)
    {
        return getAccessibleObjectsArray(object.getClass());
    }


    @Override
    public void makeMethodAccessible(Method method)
    {
        new MakeMethodAccessibleTask().run(method);
    }
    
    
    @Override
    public void makeInstanceVariableAccessible(Field InstanceVariable)
    {
        new MakeInstanceVariableAccessibleTask().run(InstanceVariable);
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
    public Object instantiateClass(String className)
    {
        return instantiateClass(loadClass(className));
    }


    @Override
    public Method getMethod(Object object, String methodName)
    {
        return new GetMethodTask().run(object, methodName);
    }
}
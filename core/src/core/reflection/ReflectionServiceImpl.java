package core.reflection;

import java.lang.reflect.Method;
import core.OrionObject;
import core.reflection.tasks.CallMethodTask;
import core.reflection.tasks.GetMethodsArrayTask;
import core.reflection.tasks.InstantiateClassTask;
import core.reflection.tasks.LoadClassTask;
import core.reflection.tasks.MakeMethodAccessibleTask;

public class ReflectionServiceImpl implements ReflectionService
{
    @Override
    public Method[] getMethodsArray(OrionObject object)
    {
        return (Method[])new GetMethodsArrayTask().execute(object);
    }
    
    
    @Override
    public void makeMethodAccessible(Method method)
    {
        new MakeMethodAccessibleTask().execute(method);
    }


    @Override
    public void callMethod(Method method, Object objectMethodBelongsTo, Object... methodArguments)
    {
        new CallMethodTask().execute(method, objectMethodBelongsTo, methodArguments);
    }
    
    
    @Override
    public Class<?> loadClass(String className)
    {
        return (Class<?>)new LoadClassTask().execute(className);
    }
    
    
    @Override
    public Object instantiateClass(Class<?> classToInstantiate)
    {
        return new InstantiateClassTask().execute(classToInstantiate);
    }
    
    
    @Override
    public Object loadAndInstantiateClass(String className)
    {
        return instantiateClass(loadClass(className));
    }
}
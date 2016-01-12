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
        return (Method[])new GetMethodsArrayTask().run(object);
    }
    
    
    @Override
    public void makeMethodAccessible(Method method)
    {
        new MakeMethodAccessibleTask().run(method);
    }


    @Override
    public void callMethod(Method method, Object objectMethodBelongsTo, Object... methodArguments)
    {
        new CallMethodTask().run(method, objectMethodBelongsTo, methodArguments);
    }
    
    
    @Override
    public Class<?> loadClass(String className)
    {
        return (Class<?>)new LoadClassTask().run(className);
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
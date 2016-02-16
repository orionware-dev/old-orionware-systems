package core.reflection.loader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import core.OrionSimpleObject;
import core.reflection.loader.tasks.CallConstructorTask;
import core.reflection.loader.tasks.CallMethodTask;
import core.reflection.loader.tasks.GetConstructorsArrayTask;
import core.reflection.loader.tasks.GetMethodsArrayTask;
import core.reflection.loader.tasks.InstantiateClassTask;
import core.reflection.loader.tasks.LoadClassTask;
import core.reflection.loader.tasks.MakeMethodAccessibleTask;

public class ReflectionServiceImpl extends OrionSimpleObject implements ReflectionService
{
    private GetMethodsArrayTask getMethodsArrayTask = new GetMethodsArrayTask();
    private GetConstructorsArrayTask getConstructorsArrayTask = new GetConstructorsArrayTask();
    private MakeMethodAccessibleTask makeMethodAccessibleTask = new MakeMethodAccessibleTask();
    private CallMethodTask callMethodTask = new CallMethodTask();
    private CallConstructorTask callConstructorTask = new CallConstructorTask();
    private LoadClassTask loadClassTask = new LoadClassTask();
    private InstantiateClassTask instantiateClassTask = new InstantiateClassTask();
    
    
    @Override
    public Method[] getMethodsArray(Object object)
    {
        return getMethodsArrayTask.run(object);
    }
    
    
    @Override
    public Constructor<?>[] getConstructorsArray(Object object)
    {
        return getConstructorsArrayTask.run(object);
    }
    
    
    @Override
    public void makeMethodAccessible(Method method)
    {
        makeMethodAccessibleTask.run(method);
    }


    @Override
    public void callMethod(Method method, Object objectMethodBelongsTo, Object... methodArguments)
    {
        callMethodTask.run(method, objectMethodBelongsTo, methodArguments);
    }
    
    
    @Override
    public void callConstructor(Constructor<?> constructor, Object... constructorArguments)
    {
        callConstructorTask.run(constructor, constructorArguments);
    }
    
    
    @Override
    public Class<?> loadClass(String className)
    {
        return loadClassTask.run(className);
    }
    
    
    @Override
    public Object instantiateClass(Class<?> classToInstantiate)
    {
        return instantiateClassTask.run(classToInstantiate);
    }
    
    
    @Override
    public Object loadAndInstantiateClass(String className)
    {
        return instantiateClass(loadClass(className));
    }
}
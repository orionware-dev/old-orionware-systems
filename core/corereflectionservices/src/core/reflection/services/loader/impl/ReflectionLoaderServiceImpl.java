package core.reflection.services.loader.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import core.reflection.services.ReflectionServiceObject;
import core.reflection.services.loader.ReflectionLoaderService;
import core.reflection.services.loader.impl.tasks.CallConstructorTask;
import core.reflection.services.loader.impl.tasks.CallMethodTask;
import core.reflection.services.loader.impl.tasks.GetConstructorsArrayTask;
import core.reflection.services.loader.impl.tasks.GetMethodsArrayTask;
import core.reflection.services.loader.impl.tasks.InstantiateClassTask;
import core.reflection.services.loader.impl.tasks.LoadClassTask;
import core.reflection.services.loader.impl.tasks.MakeMethodAccessibleTask;

public class ReflectionLoaderServiceImpl extends ReflectionServiceObject implements ReflectionLoaderService
{
    private GetMethodsArrayTask getMethodsArrayTask;
    private GetConstructorsArrayTask getConstructorsArrayTask;
    private MakeMethodAccessibleTask makeMethodAccessibleTask;
    private CallMethodTask callMethodTask;
    private CallConstructorTask callConstructorTask;
    private LoadClassTask loadClassTask;
    private InstantiateClassTask instantiateClassTask;
    
    
    public ReflectionLoaderServiceImpl()
    {
        this.getMethodsArrayTask = new GetMethodsArrayTask();
        this.getConstructorsArrayTask = new GetConstructorsArrayTask();
        this.makeMethodAccessibleTask = new MakeMethodAccessibleTask();
        this.callMethodTask = new CallMethodTask();
        this.callConstructorTask = new CallConstructorTask();
        this.loadClassTask = new LoadClassTask();
        this.instantiateClassTask = new InstantiateClassTask();
    }
    
    
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
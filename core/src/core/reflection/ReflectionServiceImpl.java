package core.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import core.OrionObject;
import core.reflection.tasks.CallConstructorTask;
import core.reflection.tasks.CallMethodTask;
import core.reflection.tasks.GetConstructorsArrayTask;
import core.reflection.tasks.GetMethodsArrayTask;
import core.reflection.tasks.InstantiateClassTask;
import core.reflection.tasks.LoadClassTask;
import core.reflection.tasks.MakeMethodAccessibleTask;

public class ReflectionServiceImpl implements ReflectionService
{
    private GetMethodsArrayTask getMethodsArrayTask;
    private GetConstructorsArrayTask getConstructorsArrayTask;
    private MakeMethodAccessibleTask makeMethodAccessibleTask;
    private CallMethodTask callMethodTask;
    private CallConstructorTask callConstructorTask;
    private LoadClassTask loadClassTask;
    private InstantiateClassTask instantiateClassTask;
    
    
    public ReflectionServiceImpl()
    {
        initialiseDependencies();
    }
    
    
    private void initialiseDependencies()
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
    public Method[] getMethodsArray(OrionObject object)
    {
        return getMethodsArrayTask.run(object);
    }
    
    
    @Override
    public Constructor<?>[] getConstructorsArray(OrionObject object)
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
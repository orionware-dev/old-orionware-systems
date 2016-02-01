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
    private GetMethodsArrayTask getMethodsArrayTask = new GetMethodsArrayTask();
    private GetConstructorsArrayTask getConstructorsArrayTask = new GetConstructorsArrayTask();
    private MakeMethodAccessibleTask makeMethodAccessibleTask = new MakeMethodAccessibleTask();
    private CallMethodTask callMethodTask = new CallMethodTask();
    private CallConstructorTask callConstructorTask = new CallConstructorTask();
    private LoadClassTask loadClassTask = new LoadClassTask();
    private InstantiateClassTask instantiateClassTask = new InstantiateClassTask();
    
    
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
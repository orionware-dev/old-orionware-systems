package core.reflection.facades.loader.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import core.reflection.facades.ReflectionFacadeObject;
import core.reflection.facades.loader.ReflectionFacade;
import core.reflection.services.loader.ReflectionService;
import core.reflection.services.loader.impl.ReflectionServiceImpl;

public class ReflectionFacadeImpl extends ReflectionFacadeObject implements ReflectionFacade
{
    private ReflectionService reflectionService;
    
    
    public ReflectionFacadeImpl()
    {
        this.reflectionService = new ReflectionServiceImpl();
    }
    
    
    @Override
    public Method[] getMethodsArray(Object object)
    {
        return reflectionService.getMethodsArray(object);
    }

    
    @Override
    public Constructor<?>[] getConstructorsArray(Object object)
    {
        return reflectionService.getConstructorsArray(object);
    }

    
    @Override
    public void makeMethodAccessible(Method method)
    {
        reflectionService.makeMethodAccessible(method);
    }

    
    @Override
    public void callMethod(Method method, Object objectMethodBelongsTo, Object... methodArguments)
    {
        reflectionService.callMethod(method, objectMethodBelongsTo, methodArguments);
    }

    
    @Override
    public void callConstructor(Constructor<?> constructor, Object... constructorArguments)
    {
        reflectionService.callConstructor(constructor, constructorArguments);
    }

    
    @Override
    public Class<?> loadClass(String className)
    {
        return reflectionService.loadClass(className);
    }

    
    @Override
    public Object instantiateClass(Class<?> classToInstantiate)
    {
        return reflectionService.instantiateClass(classToInstantiate);
    }

    
    @Override
    public Object loadAndInstantiateClass(String className)
    {
        return reflectionService.loadAndInstantiateClass(className);
    }
}
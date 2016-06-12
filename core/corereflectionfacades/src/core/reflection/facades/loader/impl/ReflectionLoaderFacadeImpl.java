package core.reflection.facades.loader.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import core.reflection.facades.ReflectionFacadeObject;
import core.reflection.facades.loader.ReflectionLoaderFacade;
import core.reflection.services.loader.ReflectionLoaderService;
import core.reflection.services.loader.impl.ReflectionLoaderServiceImpl;

public class ReflectionLoaderFacadeImpl extends ReflectionFacadeObject implements ReflectionLoaderFacade
{
    private ReflectionLoaderService reflectionLoaderService;


    public ReflectionLoaderFacadeImpl()
    {
        this.reflectionLoaderService = new ReflectionLoaderServiceImpl();
    }


    @Override
    public Method[] getMethodsArray(Object object)
    {
        return reflectionLoaderService.getMethodsArray(object);
    }


    @Override
    public Constructor<?>[] getConstructorsArray(Object object)
    {
        return reflectionLoaderService.getConstructorsArray(object);
    }


    @Override
    public void makeMethodAccessible(Method method)
    {
        reflectionLoaderService.makeMethodAccessible(method);
    }


    @Override
    public void callMethod(Method method, Object objectMethodBelongsTo, Object... methodArguments)
    {
        reflectionLoaderService.callMethod(method, objectMethodBelongsTo, methodArguments);
    }


    @Override
    public void callConstructor(Constructor<?> constructor, Object... constructorArguments)
    {
        reflectionLoaderService.callConstructor(constructor, constructorArguments);
    }


    @Override
    public Class<?> loadClass(String className)
    {
        return reflectionLoaderService.loadClass(className);
    }


    @Override
    public Object instantiateClass(Class<?> classToInstantiate)
    {
        return reflectionLoaderService.instantiateClass(classToInstantiate);
    }


    @Override
    public Object loadAndInstantiateClass(String className)
    {
        return reflectionLoaderService.loadAndInstantiateClass(className);
    }
}
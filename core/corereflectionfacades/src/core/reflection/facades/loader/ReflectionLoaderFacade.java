package core.reflection.facades.loader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import core.reflection.ReflectionFacade;

public interface ReflectionLoaderFacade extends ReflectionFacade
{
    public Method[] getMethodsArray(Object object);


    public Constructor<?>[] getConstructorsArray(Object object);


    public void makeMethodAccessible(Method method);


    public void callMethod(Method method, Object objectMethodBelongsTo, Object... methodArguments);


    public void callConstructor(Constructor<?> constructor, Object... constructorArguments);


    public Class<?> loadClass(String className);


    public Object instantiateClass(Class<?> classToInstantiate);


    public Object instantiateClass(String className);
}
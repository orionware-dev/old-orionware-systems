package core.reflection.services.loader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import core.reflection.ReflectionService;

public interface ReflectionLoaderService extends ReflectionService
{
    public Method getMethodFromClass(String methodName, Class<?> aClass, Class<?>... methodParameterTypes);


    public Method[] getMethodsArray(Object object);


    public Constructor<?>[] getConstructorsArray(Object object);


    public void makeMethodAccessible(Method method);


    public Object callMethod(Method method, Object objectMethodBelongsTo, Object... methodArguments);


    public void callConstructor(Constructor<?> constructor, Object... constructorArguments);


    public Class<?> loadClass(String className);


    public Object instantiateClass(Class<?> classToInstantiate);


    public Object loadAndInstantiateClass(String className);
}
package reflection.services.loader;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import reflection.ReflectionService;

public interface ReflectionLoaderService extends ReflectionService
{
    public Method getMethodFromClass(String methodName, Class<?> aClass, Class<?>... methodParameterTypes);
    
    
    public Field[] getInstanceVariablesArray(Object object);
    
    
    public Field[] getInstanceVariablesArray(Class<?> aClass);


    public Method[] getMethodsArray(Object object);
    
    
    public Method[] getMethodsArray(Class<?> aClass);


    public Constructor<?>[] getConstructorsArray(Object object);
    
    
    public Constructor<?>[] getConstructorsArray(Class<?> aClass);
    
    
public AccessibleObject[] getAccessibleObjectsArray(Class<?> aClass);
    
    
    public AccessibleObject[] getAccessibleObjectsArray(Object object);


    public void makeMethodAccessible(Method method);
    
    
    public void makeInstanceVariableAccessible(Field instanceVariable);


    public Object callMethod(Method method, Object objectMethodBelongsTo, Object... methodArguments);


    public void callConstructor(Constructor<?> constructor, Object... constructorArguments);


    public Class<?> loadClass(String className);


    public Object instantiateClass(Class<?> classToInstantiate);


    public Object instantiateClass(String className);
    
    
    public Method getMethod(Object object, String methodName);
}
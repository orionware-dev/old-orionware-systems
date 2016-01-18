package core.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import core.OrionObject;
import core.services.OrionService;

public interface ReflectionService extends OrionService
{
    public Method[] getMethodsArray(OrionObject object);
    
    
    public Constructor<?>[] getConstructorsArray(OrionObject object);
    
    
    public void makeMethodAccessible(Method method);
    
    
    public void callMethod(Method method, Object objectMethodBelongsTo, Object... methodArguments);
    
    
    public void callConstructor(Constructor<?> constructor, Object... constructorArguments);
    
    
    public Class<?> loadClass(String className);
    
    
    public Object instantiateClass(Class<?> classToInstantiate);
    
    
    public Object loadAndInstantiateClass(String className);
}
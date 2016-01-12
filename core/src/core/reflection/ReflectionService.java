package core.reflection;

import java.lang.reflect.Method;
import core.OrionObject;
import core.services.OrionService;

public interface ReflectionService extends OrionService
{
    public Method[] getMethodsArray(OrionObject object);
    
    
    public void makeMethodAccessible(Method method);
    
    
    public void callMethod(Method method, Object objectMethodBelongsTo, Object... methodArguments);
    
    
    public Class<?> loadClass(String className);
    
    
    public Object instantiateClass(Class<?> classToInstantiate);
    
    
    public Object loadAndInstantiateClass(String className);
}
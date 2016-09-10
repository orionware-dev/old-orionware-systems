package reflection.services.accessibleobjects.methods;

import java.lang.reflect.Method;
import reflection.ReflectionService;

public interface ReflectionMethodsService extends ReflectionService
{
    public Method getMethod(String methodName, Class<?> aClass, Class<?>... methodParameterTypes);
    
    
    public Method getMethod(String methodName, Object object, Class<?>... methodParameterTypes);


    public Method[] getMethodsArray(Object object);
    
    
    public Method[] getMethodsArray(Class<?> aClass);
    
    
    public Method[] getInherittedMethodsArray(Object object);
    
    
    public Method[] getInherittedMethodsArray(Class<?> aClass);


    public void makeMethodAccessible(Method method);


    public Object callMethod(Method method, Object objectMethodBelongsTo, Object... methodArguments);
    
    
    public Method getMethod(Object object, String methodName);
}
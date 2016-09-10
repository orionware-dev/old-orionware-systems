package reflection.services.accessibleobjects.methods;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import reflection.ReflectionService;

public interface ReflectionMethodsService extends ReflectionService
{
    public Method getMethodFromClass(String methodName, Class<?> aClass, Class<?>... methodParameterTypes);


    public Method[] getMethodsArray(Object object);
    
    
    public Method[] getMethodsArray(Class<?> aClass);


    public void makeMethodAccessible(Method method);


    public Object callMethod(Method method, Object objectMethodBelongsTo, Object... methodArguments);
    
    
    public Method getMethod(Object object, String methodName);
}
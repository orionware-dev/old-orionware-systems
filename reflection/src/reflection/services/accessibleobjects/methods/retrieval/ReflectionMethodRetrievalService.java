package reflection.services.accessibleobjects.methods.retrieval;

import java.lang.reflect.Method;
import reflection.ReflectionService;

public interface ReflectionMethodRetrievalService extends ReflectionService
{
    public Method getDeclaredMethod(String methodName, Object object, Class<?>... methodParameterTypes);
    
    
    public Method getDeclaredMethod(String methodName, Class<?> aClass, Class<?>... methodParameterTypes);
    
    
    public Method getPrivateMethod(String methodName, Object object, Class<?>... methodParameterTypes);
    
    
    public Method getPrivateMethod(String methodName, Class<?> aClass, Class<?>... methodParameterTypes);
    
    
    public Method getDeclaredDefaultMethod(String methodName, Object object, Class<?>... methodParameterTypes);
    
    
    public Method getDeclaredDefaultMethod(String methodName, Class<?> aClass, Class<?>... methodParameterTypes);
    
    
    public Method getDeclaredPublicMethod(String methodName, Object object, Class<?>... methodParameterTypes);
    
    
    public Method getDeclaredPublicMethod(String methodName, Class<?> aClass, Class<?>... methodParameterTypes);
    
    
    public Method getDeclaredProtectedMethod(String methodName, Object object, Class<?>... methodParameterTypes);
    
    
    public Method getDeclaredProtectedMethod(String methodName, Class<?> aClass, Class<?>... methodParameterTypes);
    
    
    public Method getInherittedMethod(String methodName, Object object, Class<?>... methodParameterTypes);
    
    
    public Method getInherittedMethod(String methodName, Class<?> aClass, Class<?>... methodParameterTypes);
}
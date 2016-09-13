package reflection.constructors.retrieval;

import java.lang.reflect.Constructor;
import reflection.ReflectionService;

public interface ReflectionConstructorRetrievalService extends ReflectionService
{
    public Constructor<?> getDeclaredConstructor(Object object, Class<?>... constructorParameterTypes);
    
    
    public Constructor<?> getDeclaredConstructor(Class<?> aClass, Class<?>... constructorParameterTypes);
    
    
    public Constructor<?> getPublicConstructor(Object object, Class<?>... constructorParameterTypes);
    
    
    public Constructor<?> getPublicConstructor(Class<?> aClass, Class<?>... constructorParameterTypes);
}
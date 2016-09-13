package reflection.constructors.retrieval;

import java.lang.reflect.Constructor;
import java.util.List;
import reflection.ReflectionService;

public interface ReflectionConstructorsRetrievalService extends ReflectionService
{
    public Constructor<?>[] getDeclaredConstructorsArray(Object object);
    
    
    public Constructor<?>[] getDeclaredConstructorsArray(Class<?> aClass);
    
    
    public List<Constructor<?>> getDeclaredConstructors(Object object);
    
    
    public List<Constructor<?>> getDeclaredConstructors(Class<?> aClass);
    
    
    public Constructor<?>[] getPublicConstructorsArray(Object object);
    
    
    public Constructor<?>[] getPublicConstructorsArray(Class<?> aClass);
    
    
    public List<Constructor<?>> getPublicConstructors(Object object);
    
    
    public List<Constructor<?>> getPublicConstructors(Class<?> aClass);
}
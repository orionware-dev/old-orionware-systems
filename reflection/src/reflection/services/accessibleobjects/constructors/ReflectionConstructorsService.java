package reflection.services.accessibleobjects.constructors;

import java.lang.reflect.Constructor;
import reflection.ReflectionService;

public interface ReflectionConstructorsService extends ReflectionService
{
    public Constructor<?>[] getConstructorsArray(Object object);
    
    
    public Constructor<?>[] getConstructorsArray(Class<?> aClass);
    
    
    public Constructor<?>[] getInherittedConstructorsArray(Object object);
    
    
    public Constructor<?>[] getInherittedConstructorsArray(Class<?> aClass);


    public void callConstructor(Constructor<?> constructor, Object... constructorArguments);
}
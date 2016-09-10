package reflection.services.accessibleobjects.constructors;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import reflection.ReflectionService;

public interface ReflectionConstructorsService extends ReflectionService
{
    public Constructor<?>[] getConstructorsArray(Object object);
    
    
    public Constructor<?>[] getConstructorsArray(Class<?> aClass);


    public void callConstructor(Constructor<?> constructor, Object... constructorArguments);
}
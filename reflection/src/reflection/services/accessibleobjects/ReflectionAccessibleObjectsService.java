package reflection.services.accessibleobjects;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import reflection.ReflectionService;

public interface ReflectionAccessibleObjectsService extends ReflectionService
{
    public AccessibleObject[] getAccessibleObjectsArray(Class<?> aClass);
    
    
    public AccessibleObject[] getAccessibleObjectsArray(Object object);
}
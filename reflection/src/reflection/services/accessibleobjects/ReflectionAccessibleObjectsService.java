package reflection.services.accessibleobjects;

import java.lang.reflect.AccessibleObject;
import reflection.ReflectionService;

public interface ReflectionAccessibleObjectsService extends ReflectionService
{
    public AccessibleObject[] getAccessibleObjectsArray(Class<?> aClass);
    
    
    public AccessibleObject[] getAccessibleObjectsArray(Object object);
}
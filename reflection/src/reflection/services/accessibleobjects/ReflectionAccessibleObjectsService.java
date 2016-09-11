package reflection.services.accessibleobjects;

import java.lang.reflect.AccessibleObject;
import java.util.List;
import reflection.ReflectionService;

public interface ReflectionAccessibleObjectsService extends ReflectionService
{
    public AccessibleObject[] getDeclaredAccessibleObjectsArray(Class<?> aClass);
    
    
    public AccessibleObject[] getDeclaredAccessibleObjectsArray(Object object);
    
    
    public List<AccessibleObject> getDeclaredAccessibleObjects(Class<?> aClass);
    
    
    public List<AccessibleObject> getDeclaredAccessibleObjects(Object object);
}
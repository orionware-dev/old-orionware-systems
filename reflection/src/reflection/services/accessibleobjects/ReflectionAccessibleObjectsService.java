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


    public AccessibleObject[] getInherittedAccessibleObjectsArray(Class<?> aClass);


    public AccessibleObject[] getInherittedAccessibleObjectsArray(Object object);


    public List<AccessibleObject> getInherittedAccessibleObjects(Class<?> aClass);


    public List<AccessibleObject> getInherittedAccessibleObjects(Object object);


    public AccessibleObject[] getAllAccessibleObjectsArray(Class<?> aClass);


    public AccessibleObject[] getAllAccessibleObjectsArray(Object object);


    public List<AccessibleObject> getAllAccessibleObjects(Class<?> aClass);


    public List<AccessibleObject> getAllAccessibleObjects(Object object);
}
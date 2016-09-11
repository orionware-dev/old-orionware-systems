package reflection.services.accessibleobjects.impl;

import java.lang.reflect.AccessibleObject;
import java.util.Arrays;
import java.util.List;
import reflection.services.ReflectionServiceObject;
import reflection.services.accessibleobjects.ReflectionAccessibleObjectsService;
import reflection.services.accessibleobjects.impl.tasks.GetAccessibleObjectsArrayTask;

public class ReflectionAccessibleObjectsServiceImpl extends ReflectionServiceObject implements ReflectionAccessibleObjectsService
{
    @Override
    public AccessibleObject[] getDeclaredAccessibleObjectsArray(Class<?> aClass)
    {
        return new GetAccessibleObjectsArrayTask().run(aClass);
    }


    @Override
    public AccessibleObject[] getDeclaredAccessibleObjectsArray(Object object)
    {
        return new GetAccessibleObjectsArrayTask().run(object);
    }


    @Override
    public List<AccessibleObject> getDeclaredAccessibleObjects(Class<?> aClass)
    {
        return Arrays.asList(getDeclaredAccessibleObjectsArray(aClass));
    }


    @Override
    public List<AccessibleObject> getDeclaredAccessibleObjects(Object object)
    {
        return Arrays.asList(getDeclaredAccessibleObjectsArray(object));
    }
}
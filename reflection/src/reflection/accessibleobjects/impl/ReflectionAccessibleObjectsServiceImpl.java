package reflection.accessibleobjects.impl;

import java.lang.reflect.AccessibleObject;
import java.util.Arrays;
import java.util.List;
import reflection.ReflectionServiceObject;
import reflection.accessibleobjects.ReflectionAccessibleObjectsService;
import reflection.accessibleobjects.impl.tasks.GetAllAccessibleObjectsArrayTask;
import reflection.accessibleobjects.impl.tasks.GetDeclaredAccessibleObjectsArrayTask;
import reflection.accessibleobjects.impl.tasks.GetInherittedAccessibleObjectsArrayTask;

public class ReflectionAccessibleObjectsServiceImpl extends ReflectionServiceObject implements ReflectionAccessibleObjectsService
{
    @Override
    public AccessibleObject[] getDeclaredAccessibleObjectsArray(Class<?> aClass)
    {
        return new GetDeclaredAccessibleObjectsArrayTask().run(aClass);
    }


    @Override
    public AccessibleObject[] getDeclaredAccessibleObjectsArray(Object object)
    {
        return new GetDeclaredAccessibleObjectsArrayTask().run(object);
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


    @Override
    public AccessibleObject[] getInherittedAccessibleObjectsArray(Class<?> aClass)
    {
        return new GetInherittedAccessibleObjectsArrayTask().run(aClass);
    }


    @Override
    public AccessibleObject[] getInherittedAccessibleObjectsArray(Object object)
    {
        return new GetInherittedAccessibleObjectsArrayTask().run(object);
    }


    @Override
    public List<AccessibleObject> getInherittedAccessibleObjects(Class<?> aClass)
    {
        return Arrays.asList(getInherittedAccessibleObjectsArray(aClass));
    }


    @Override
    public List<AccessibleObject> getInherittedAccessibleObjects(Object object)
    {
        return Arrays.asList(getInherittedAccessibleObjectsArray(object));
    }


    @Override
    public AccessibleObject[] getAllAccessibleObjectsArray(Class<?> aClass)
    {
        return new GetAllAccessibleObjectsArrayTask().run(aClass);
    }


    @Override
    public AccessibleObject[] getAllAccessibleObjectsArray(Object object)
    {
        return new GetAllAccessibleObjectsArrayTask().run(object);
    }


    @Override
    public List<AccessibleObject> getAllAccessibleObjects(Class<?> aClass)
    {
        return Arrays.asList(getInherittedAccessibleObjectsArray(aClass));
    }


    @Override
    public List<AccessibleObject> getAllAccessibleObjects(Object object)
    {
        return Arrays.asList(getInherittedAccessibleObjectsArray(object));
    }
}
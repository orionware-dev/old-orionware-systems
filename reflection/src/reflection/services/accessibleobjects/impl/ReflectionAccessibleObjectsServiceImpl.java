package reflection.services.accessibleobjects.impl;

import java.lang.reflect.AccessibleObject;
import reflection.services.ReflectionServiceObject;
import reflection.services.accessibleobjects.ReflectionAccessibleObjectsService;
import reflection.services.accessibleobjects.impl.tasks.GetAccessibleObjectsArrayTask;

public class ReflectionAccessibleObjectsServiceImpl extends ReflectionServiceObject implements ReflectionAccessibleObjectsService
{
    @Override
    public AccessibleObject[] getAccessibleObjectsArray(Class<?> aClass)
    {
        return new GetAccessibleObjectsArrayTask().run(aClass);
    }
    
    
    @Override
    public AccessibleObject[] getAccessibleObjectsArray(Object object)
    {
        return getAccessibleObjectsArray(object.getClass());
    }
}
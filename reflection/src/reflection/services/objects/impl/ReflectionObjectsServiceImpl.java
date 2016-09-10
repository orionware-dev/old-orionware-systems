package reflection.services.objects.impl;

import reflection.services.ReflectionServiceObject;
import reflection.services.objects.ReflectionObjectsService;
import reflection.services.objects.impl.tasks.AreObjectsNotNullTask;
import reflection.services.objects.impl.tasks.AreObjectsNullTask;

public class ReflectionObjectsServiceImpl extends ReflectionServiceObject implements ReflectionObjectsService
{
    @Override
    public boolean isObjectNull(Object object)
    {
        return object == null;
    }
    
    
    @Override
    public boolean isObjectNotNull(Object object)
    {
        return object != null;
    }

    
    @Override
    public boolean areObjectsNull(Object... objects)
    {
        return new AreObjectsNullTask().run(objects);
    }
    
    
    @Override
    public boolean areObjectsNotNull(Object... objects)
    {
        return new AreObjectsNotNullTask().run(objects);
    }
}
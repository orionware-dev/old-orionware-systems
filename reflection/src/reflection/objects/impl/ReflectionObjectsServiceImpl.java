package reflection.objects.impl;

import reflection.ReflectionServiceObject;
import reflection.objects.ReflectionObjectsService;
import reflection.objects.impl.tasks.AreObjectsNotNullTask;
import reflection.objects.impl.tasks.AreObjectsNullTask;
import reflection.objects.impl.tasks.IsObjectNotNullTask;
import reflection.objects.impl.tasks.IsObjectNullTask;

public class ReflectionObjectsServiceImpl extends ReflectionServiceObject implements ReflectionObjectsService
{
    @Override
    public boolean isObjectNull(Object object)
    {
        return IsObjectNullTask.run(object);
    }


    @Override
    public boolean isObjectNotNull(Object object)
    {
        return IsObjectNotNullTask.run(object);
    }


    @Override
    public boolean areObjectsNull(Object... objects)
    {
        return AreObjectsNullTask.run(objects);
    }


    @Override
    public boolean areObjectsNotNull(Object... objects)
    {
        return AreObjectsNotNullTask.run(objects);
    }
}
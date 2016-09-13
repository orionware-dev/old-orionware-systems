package reflection.accessibleobjects.impl.tasks;

import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetAllAccessibleObjectsArrayTask extends ReflectionObject implements ReflectionTask
{
    public AccessibleObject[] run(Class<?> aClass)
    {
        List<AccessibleObject> accessibleObjects = new ArrayList<AccessibleObject>();
        accessibleObjects.addAll(Arrays.asList(new GetDeclaredAccessibleObjectsArrayTask().run(aClass)));
        accessibleObjects.addAll(Arrays.asList(new GetInherittedAccessibleObjectsArrayTask().run(aClass)));
        return accessibleObjects.toArray(new AccessibleObject[0]);
    }


    public AccessibleObject[] run(Object object)
    {
        return run(object);
    }
}
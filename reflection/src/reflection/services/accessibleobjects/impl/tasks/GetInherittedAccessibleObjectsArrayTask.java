package reflection.services.accessibleobjects.impl.tasks;

import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import reflection.ReflectionObject;
import reflection.ReflectionTask;
import reflection.services.accessibleobjects.instancevariables.retrieval.impl.tasks.GetInherittedInstanceVariablesArrayTask;
import reflection.services.accessibleobjects.methods.retrieval.impl.tasks.GetInherittedMethodsArrayTask;

public class GetInherittedAccessibleObjectsArrayTask extends ReflectionObject implements ReflectionTask
{
    public AccessibleObject[] run(Class<?> aClass)
    {
        List<AccessibleObject> accessibleObjects = new ArrayList<AccessibleObject>();
        accessibleObjects.addAll(Arrays.asList(new GetInherittedInstanceVariablesArrayTask().run(aClass)));
        accessibleObjects.addAll(Arrays.asList(new GetInherittedMethodsArrayTask().run(aClass)));
        return accessibleObjects.toArray(new AccessibleObject[0]);
    }


    public AccessibleObject[] run(Object object)
    {
        return run(object);
    }
}
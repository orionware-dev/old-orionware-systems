package reflection.services.accessibleobjects.impl.tasks;

import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import reflection.ReflectionObject;
import reflection.ReflectionTask;
import reflection.services.accessibleobjects.constructors.retrieval.impl.tasks.GetDeclaredConstructorsArrayTask;
import reflection.services.accessibleobjects.instancevariables.impl.tasks.GetInstanceVariablesArrayTask;
import reflection.services.accessibleobjects.methods.retrieval.impl.tasks.GetDeclaredMethodsArrayTask;

public class GetAccessibleObjectsArrayTask extends ReflectionObject implements ReflectionTask
{
    public AccessibleObject[] run(Class<?> aClass)
    {
        List<AccessibleObject> accessibleObjects = new ArrayList<AccessibleObject>();
        accessibleObjects.addAll(Arrays.asList(new GetInstanceVariablesArrayTask().run(aClass)));
        accessibleObjects.addAll(Arrays.asList(new GetDeclaredConstructorsArrayTask().run(aClass)));
        accessibleObjects.addAll(Arrays.asList(new GetDeclaredMethodsArrayTask().run(aClass)));
        return accessibleObjects.toArray(new AccessibleObject[0]);
    }
    
    
    public AccessibleObject[] run(Object object)
    {
        return run(object);
    }
}
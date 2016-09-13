package reflection.accessibleobjects.impl.tasks;

import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import reflection.ReflectionObject;
import reflection.ReflectionTask;
import reflection.constructors.retrieval.impl.tasks.GetDeclaredConstructorsArrayTask;
import reflection.instancevariables.retrieval.impl.tasks.GetDeclaredInstanceVariablesArrayTask;
import reflection.methods.retrieval.impl.tasks.GetDeclaredMethodsArrayTask;

public class GetDeclaredAccessibleObjectsArrayTask extends ReflectionObject implements ReflectionTask
{
    public AccessibleObject[] run(Class<?> aClass)
    {
        List<AccessibleObject> accessibleObjects = new ArrayList<AccessibleObject>();
        accessibleObjects.addAll(Arrays.asList(new GetDeclaredInstanceVariablesArrayTask().run(aClass)));
        accessibleObjects.addAll(Arrays.asList(new GetDeclaredConstructorsArrayTask().run(aClass)));
        accessibleObjects.addAll(Arrays.asList(new GetDeclaredMethodsArrayTask().run(aClass)));
        return accessibleObjects.toArray(new AccessibleObject[0]);
    }


    public AccessibleObject[] run(Object object)
    {
        return run(object);
    }
}
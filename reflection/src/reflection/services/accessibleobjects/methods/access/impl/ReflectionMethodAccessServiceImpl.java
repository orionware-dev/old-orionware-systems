package reflection.services.accessibleobjects.methods.access.impl;

import java.lang.reflect.Method;
import reflection.services.ReflectionServiceObject;
import reflection.services.accessibleobjects.methods.access.ReflectionMethodAccessService;
import reflection.services.accessibleobjects.methods.access.impl.tasks.CallMethodTask;
import reflection.services.accessibleobjects.methods.access.impl.tasks.MakeMethodAccessibleTask;

public class ReflectionMethodAccessServiceImpl extends ReflectionServiceObject implements ReflectionMethodAccessService
{
    @Override
    public void makeMethodAccessible(Method method)
    {
        new MakeMethodAccessibleTask().run(method);
    }


    @Override
    public Object callMethod(Method method, Object objectMethodBelongsTo, Object... methodArguments)
    {
        makeMethodAccessible(method);
        return new CallMethodTask().run(method, objectMethodBelongsTo, methodArguments);
    }
}
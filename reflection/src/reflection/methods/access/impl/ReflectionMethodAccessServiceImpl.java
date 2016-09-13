package reflection.methods.access.impl;

import java.lang.reflect.Method;
import reflection.ReflectionServiceObject;
import reflection.methods.access.ReflectionMethodAccessService;
import reflection.methods.access.impl.tasks.CallMethodTask;
import reflection.methods.access.impl.tasks.MakeMethodAccessibleTask;

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
        return new CallMethodTask().run(method, objectMethodBelongsTo, methodArguments);
    }
}
package reflection.instancevariables.access.impl;

import java.lang.reflect.Field;
import reflection.ReflectionServiceObject;
import reflection.instancevariables.access.ReflectionInstanceVariablesAccessService;
import reflection.instancevariables.access.impl.tasks.MakeInstanceVariableAccessibleTask;

public class ReflectionInstanceVariablesAccessServiceImpl extends ReflectionServiceObject implements ReflectionInstanceVariablesAccessService
{
    @Override
    public void makeInstanceVariableAccessible(Field InstanceVariable)
    {
        new MakeInstanceVariableAccessibleTask().run(InstanceVariable);
    }
}
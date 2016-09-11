package reflection.services.accessibleobjects.instancevariables.access.impl;

import java.lang.reflect.Field;
import reflection.services.ReflectionServiceObject;
import reflection.services.accessibleobjects.instancevariables.ReflectionInstanceVariablesService;
import reflection.services.accessibleobjects.instancevariables.access.ReflectionInstanceVariablesAccessService;
import reflection.services.accessibleobjects.instancevariables.access.impl.tasks.MakeInstanceVariableAccessibleTask;
import reflection.services.accessibleobjects.instancevariables.impl.tasks.GetInherittedInstanceVariablesArrayTask;
import reflection.services.accessibleobjects.instancevariables.impl.tasks.GetInstanceVariablesArrayTask;

public class ReflectionInstanceVariablesAccessServiceImpl extends ReflectionServiceObject implements ReflectionInstanceVariablesAccessService
{
    @Override
    public void makeInstanceVariableAccessible(Field InstanceVariable)
    {
        new MakeInstanceVariableAccessibleTask().run(InstanceVariable);
    }
}
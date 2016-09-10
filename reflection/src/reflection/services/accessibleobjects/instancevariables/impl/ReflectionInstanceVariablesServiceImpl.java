package reflection.services.accessibleobjects.instancevariables.impl;

import java.lang.reflect.Field;
import reflection.services.ReflectionServiceObject;
import reflection.services.accessibleobjects.instancevariables.ReflectionInstanceVariablesService;
import reflection.services.accessibleobjects.instancevariables.impl.tasks.GetInstanceVariablesArrayTask;
import reflection.services.accessibleobjects.instancevariables.impl.tasks.MakeInstanceVariableAccessibleTask;

public class ReflectionInstanceVariablesServiceImpl extends ReflectionServiceObject implements ReflectionInstanceVariablesService
{
    @Override
    public Field[] getInstanceVariablesArray(Object object)
    {
        return new GetInstanceVariablesArrayTask().run(object);
    }
    
    
    @Override
    public Field[] getInstanceVariablesArray(Class<?> aClass)
    {
        return new GetInstanceVariablesArrayTask().run(aClass);
    }
    
    
    @Override
    public void makeInstanceVariableAccessible(Field InstanceVariable)
    {
        new MakeInstanceVariableAccessibleTask().run(InstanceVariable);
    }
}
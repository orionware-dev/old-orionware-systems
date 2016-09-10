package reflection.services.accessibleobjects.instancevariables.impl;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import reflection.services.ReflectionServiceObject;
import reflection.services.accessibleobjects.ReflectionAccessibleObjectsService;
import reflection.services.accessibleobjects.classes.impl.tasks.InstantiateClassTask;
import reflection.services.accessibleobjects.classes.impl.tasks.LoadClassTask;
import reflection.services.accessibleobjects.constructors.impl.tasks.CallConstructorTask;
import reflection.services.accessibleobjects.constructors.impl.tasks.GetConstructorsArrayTask;
import reflection.services.accessibleobjects.impl.tasks.GetAccessibleObjectsArrayTask;
import reflection.services.accessibleobjects.instancevariables.ReflectionInstanceVariablesService;
import reflection.services.accessibleobjects.instancevariables.impl.tasks.GetInstanceVariablesArrayTask;
import reflection.services.accessibleobjects.instancevariables.impl.tasks.MakeInstanceVariableAccessibleTask;
import reflection.services.accessibleobjects.methods.impl.tasks.CallMethodTask;
import reflection.services.accessibleobjects.methods.impl.tasks.GetMethodFromClassTask;
import reflection.services.accessibleobjects.methods.impl.tasks.GetMethodTask;
import reflection.services.accessibleobjects.methods.impl.tasks.GetMethodsArrayTask;
import reflection.services.accessibleobjects.methods.impl.tasks.MakeMethodAccessibleTask;

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
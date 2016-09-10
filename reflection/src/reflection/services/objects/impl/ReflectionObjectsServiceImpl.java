package reflection.services.objects.impl;

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
import reflection.services.accessibleobjects.instancevariables.impl.tasks.GetInstanceVariablesArrayTask;
import reflection.services.accessibleobjects.instancevariables.impl.tasks.MakeInstanceVariableAccessibleTask;
import reflection.services.accessibleobjects.methods.impl.tasks.CallMethodTask;
import reflection.services.accessibleobjects.methods.impl.tasks.GetMethodFromClassTask;
import reflection.services.accessibleobjects.methods.impl.tasks.GetMethodTask;
import reflection.services.accessibleobjects.methods.impl.tasks.GetMethodsArrayTask;
import reflection.services.accessibleobjects.methods.impl.tasks.MakeMethodAccessibleTask;
import reflection.services.objects.ReflectionObjectsService;
import reflection.services.objects.impl.tasks.AreObjectsNotNullTask;
import reflection.services.objects.impl.tasks.AreObjectsNullTask;

public class ReflectionObjectsServiceImpl extends ReflectionServiceObject implements ReflectionObjectsService
{
    @Override
    public boolean isObjectNull(Object object)
    {
        return object == null;
    }
    
    
    @Override
    public boolean isObjectNotNull(Object object)
    {
        return object != null;
    }

    
    @Override
    public boolean areObjectsNull(Object... objects)
    {
        return new AreObjectsNullTask().run(objects);
    }
    
    
    @Override
    public boolean areObjectsNotNull(Object... objects)
    {
        return new AreObjectsNotNullTask().run(objects);
    }
}
package reflection.services.accessibleobjects.classes.impl;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import reflection.services.ReflectionServiceObject;
import reflection.services.accessibleobjects.ReflectionAccessibleObjectsService;
import reflection.services.accessibleobjects.classes.ReflectionClassesService;
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

public class ReflectionClassesServiceImpl extends ReflectionServiceObject implements ReflectionClassesService
{
    @Override
    public Class<?> loadClass(String className)
    {
        return new LoadClassTask().run(className);
    }


    @Override
    public Object instantiateClass(Class<?> classToInstantiate)
    {
        return new InstantiateClassTask().run(classToInstantiate);
    }


    @Override
    public Object instantiateClass(String className)
    {
        return instantiateClass(loadClass(className));
    }
}
package reflection.services.accessibleobjects.methods.impl;

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
import reflection.services.accessibleobjects.methods.ReflectionMethodsService;
import reflection.services.accessibleobjects.methods.impl.tasks.CallMethodTask;
import reflection.services.accessibleobjects.methods.impl.tasks.GetMethodFromClassTask;
import reflection.services.accessibleobjects.methods.impl.tasks.GetMethodTask;
import reflection.services.accessibleobjects.methods.impl.tasks.GetMethodsArrayTask;
import reflection.services.accessibleobjects.methods.impl.tasks.MakeMethodAccessibleTask;

public class ReflectionMethodsServiceImpl extends ReflectionServiceObject implements ReflectionMethodsService
{
    @Override
    public Method getMethodFromClass(String methodName, Class<?> aClass, Class<?>... methodParameterTypes)
    {
        return new GetMethodFromClassTask().run(methodName, aClass, methodParameterTypes);
    }


    @Override
    public Method[] getMethodsArray(Object object)
    {
        return new GetMethodsArrayTask().run(object);
    }
    
    
    @Override
    public Method[] getMethodsArray(Class<?> aClass)
    {
        return new GetMethodsArrayTask().run(aClass);
    }


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


    @Override
    public Method getMethod(Object object, String methodName)
    {
        return new GetMethodTask().run(object, methodName);
    }
}
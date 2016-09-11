package reflection.services.accessibleobjects.instancevariables.retrieval.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import reflection.services.ReflectionServiceObject;
import reflection.services.accessibleobjects.instancevariables.retrieval.ReflectionInstanceVariableRetrievalService;
import reflection.services.accessibleobjects.instancevariables.retrieval.impl.tasks.GetDeclaredInstanceVariableTask;
import reflection.services.accessibleobjects.instancevariables.retrieval.impl.tasks.GetPrivateInstanceVariableTask;
import reflection.services.accessibleobjects.methods.retrieval.ReflectionMethodRetrievalService;
import reflection.services.accessibleobjects.methods.retrieval.impl.tasks.GetDeclaredMethodTask;
import reflection.services.accessibleobjects.methods.retrieval.impl.tasks.GetInherittedMethodTask;
import reflection.services.accessibleobjects.methods.retrieval.impl.tasks.IsDefaultMethodTask;
import reflection.services.accessibleobjects.methods.retrieval.impl.tasks.IsPrivateMethodTask;
import reflection.services.accessibleobjects.methods.retrieval.impl.tasks.IsProtectedMethodTask;
import reflection.services.accessibleobjects.methods.retrieval.impl.tasks.IsPublicMethodTask;

public class ReflectionInstanceVariableRetrievalServiceImpl extends ReflectionServiceObject implements ReflectionInstanceVariableRetrievalService
{
    @Override
    public Field getDeclaredInstanceVariable(String instanceVariableName, Object object)
    {
        return new GetDeclaredInstanceVariableTask().run(instanceVariableName, object);
    }

    
    @Override
    public Field getDeclaredInstanceVariable(String instanceVariableName, Class<?> aClass)
    {
        return new GetDeclaredInstanceVariableTask().run(instanceVariableName, aClass);
    }

    
    @Override
    public Field getPrivateInstanceVariable(String instanceVariableName, Object object)
    {
        return new GetDeclaredInstanceVariableTask().run(instanceVariableName, object);
    }

    
    @Override
    public Field getPrivateInstanceVariable(String instanceVariableName, Class<?> aClass)
    {
        return new GetDeclaredInstanceVariableTask().run(instanceVariableName, aClass);
    }

    
    @Override
    public Field getDeclaredPublicInstanceVariable(String instanceVariableName, Object object)
    {
        return null;
    }

    
    @Override
    public Field getDeclaredPublicInstanceVariable(String instanceVariableName, Class<?> aClass)
    {
        return null;
    }

    
    @Override
    public Field getDeclaredProtectedInstanceVariable(String instanceVariableName, Object object)
    {
        return null;
    }

    
    @Override
    public Field getDeclaredProtectedInstanceVariable(String instanceVariableName, Class<?> aClass)
    {
        return null;
    }

    
    @Override
    public Field getInherittedInstanceVariable(String instanceVariableName, Object object)
    {
        return null;
    }

    
    @Override
    public Field getInherittedInstanceVariable(String instanceVariableName, Class<?> aClass)
    {
        return null;
    }

    
    @Override
    public boolean isPrivateInstanceVariable(Field instanceVariable)
    {
        return false;
    }

    
    @Override
    public boolean isProtectedInstanceVariable(Field instanceVariable)
    {
        return false;
    }

    
    @Override
    public boolean isPublicInstanceVariable(Field instanceVariable)
    {
        return false;
    }
}
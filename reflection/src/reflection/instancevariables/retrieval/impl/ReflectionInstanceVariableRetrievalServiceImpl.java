package reflection.instancevariables.retrieval.impl;

import java.lang.reflect.Field;
import reflection.ReflectionServiceObject;
import reflection.instancevariables.retrieval.ReflectionInstanceVariableRetrievalService;
import reflection.instancevariables.retrieval.impl.tasks.GetDeclaredInstanceVariableTask;
import reflection.instancevariables.retrieval.impl.tasks.GetDeclaredProtectedInstanceVariableTask;
import reflection.instancevariables.retrieval.impl.tasks.GetDeclaredPublicInstanceVariableTask;
import reflection.instancevariables.retrieval.impl.tasks.GetInherittedInstanceVariableTask;
import reflection.instancevariables.retrieval.impl.tasks.GetPrivateInstanceVariableTask;
import reflection.instancevariables.retrieval.impl.tasks.IsPrivateInstanceVariableTask;
import reflection.instancevariables.retrieval.impl.tasks.IsProtectedInstanceVariableTask;
import reflection.instancevariables.retrieval.impl.tasks.IsPublicInstanceVariableTask;

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
        return new GetPrivateInstanceVariableTask().run(instanceVariableName, object);
    }


    @Override
    public Field getPrivateInstanceVariable(String instanceVariableName, Class<?> aClass)
    {
        return new GetPrivateInstanceVariableTask().run(instanceVariableName, aClass);
    }


    @Override
    public Field getDeclaredPublicInstanceVariable(String instanceVariableName, Object object)
    {
        return new GetDeclaredPublicInstanceVariableTask().run(instanceVariableName, object);
    }


    @Override
    public Field getDeclaredPublicInstanceVariable(String instanceVariableName, Class<?> aClass)
    {
        return new GetDeclaredPublicInstanceVariableTask().run(instanceVariableName, aClass);
    }


    @Override
    public Field getDeclaredProtectedInstanceVariable(String instanceVariableName, Object object)
    {
        return new GetDeclaredProtectedInstanceVariableTask().run(instanceVariableName, object);
    }


    @Override
    public Field getDeclaredProtectedInstanceVariable(String instanceVariableName, Class<?> aClass)
    {
        return new GetDeclaredProtectedInstanceVariableTask().run(instanceVariableName, aClass);
    }


    @Override
    public Field getInherittedInstanceVariable(String instanceVariableName, Object object)
    {
        return new GetInherittedInstanceVariableTask().run(instanceVariableName, object);
    }


    @Override
    public Field getInherittedInstanceVariable(String instanceVariableName, Class<?> aClass)
    {
        return new GetInherittedInstanceVariableTask().run(instanceVariableName, aClass);
    }


    @Override
    public boolean isPrivateInstanceVariable(Field instanceVariable)
    {
        return new IsPrivateInstanceVariableTask().run(instanceVariable);
    }


    @Override
    public boolean isProtectedInstanceVariable(Field instanceVariable)
    {
        return new IsProtectedInstanceVariableTask().run(instanceVariable);
    }


    @Override
    public boolean isPublicInstanceVariable(Field instanceVariable)
    {
        return new IsPublicInstanceVariableTask().run(instanceVariable);
    }
}
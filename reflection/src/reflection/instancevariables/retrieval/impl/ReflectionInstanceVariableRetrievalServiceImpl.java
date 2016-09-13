package reflection.instancevariables.retrieval.impl;

import java.lang.reflect.Field;
import reflection.ReflectionServiceObject;
import reflection.instancevariables.retrieval.ReflectionInstanceVariableRetrievalService;
import reflection.instancevariables.retrieval.impl.tasks.GetDeclaredInstanceVariableTask;
import reflection.instancevariables.retrieval.impl.tasks.GetInherittedInstanceVariableTask;
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
        Field field = new GetDeclaredInstanceVariableTask().run(instanceVariableName, object.getClass());

        if(isPrivateInstanceVariable(field))
        {
            return field;
        }

        return null;
    }


    @Override
    public Field getPrivateInstanceVariable(String instanceVariableName, Class<?> aClass)
    {
        Field field = new GetDeclaredInstanceVariableTask().run(instanceVariableName, aClass);

        if(isPrivateInstanceVariable(field))
        {
            return field;
        }

        return null;
    }


    @Override
    public Field getDeclaredPublicInstanceVariable(String instanceVariableName, Object object)
    {
        Field field = new GetDeclaredInstanceVariableTask().run(instanceVariableName, object.getClass());

        if(isPublicInstanceVariable(field))
        {
            return field;
        }

        return null;
    }


    @Override
    public Field getDeclaredPublicInstanceVariable(String instanceVariableName, Class<?> aClass)
    {
        Field field = new GetDeclaredInstanceVariableTask().run(instanceVariableName, aClass);

        if(isPublicInstanceVariable(field))
        {
            return field;
        }

        return null;
    }


    @Override
    public Field getDeclaredProtectedInstanceVariable(String instanceVariableName, Object object)
    {
        Field field = new GetDeclaredInstanceVariableTask().run(instanceVariableName, object.getClass());

        if(isProtectedInstanceVariable(field))
        {
            return field;
        }

        return null;
    }


    @Override
    public Field getDeclaredProtectedInstanceVariable(String instanceVariableName, Class<?> aClass)
    {
        Field field = new GetDeclaredInstanceVariableTask().run(instanceVariableName, aClass);

        if(isProtectedInstanceVariable(field))
        {
            return field;
        }

        return null;
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
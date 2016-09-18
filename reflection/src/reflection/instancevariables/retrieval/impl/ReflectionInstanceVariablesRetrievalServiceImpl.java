package reflection.instancevariables.retrieval.impl;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import reflection.ReflectionServiceObject;
import reflection.instancevariables.retrieval.ReflectionInstanceVariablesRetrievalService;
import reflection.instancevariables.retrieval.impl.tasks.GetAllInstanceVariablesArrayTask;
import reflection.instancevariables.retrieval.impl.tasks.declared.GetDeclaredInstanceVariablesArrayTask;
import reflection.instancevariables.retrieval.impl.tasks.declared.GetDeclaredProtectedInstanceVariablesArrayTask;
import reflection.instancevariables.retrieval.impl.tasks.declared.GetDeclaredPublicInstanceVariablesArrayTask;
import reflection.instancevariables.retrieval.impl.tasks.inheritted.GetInherittedInstanceVariablesArrayTask;
import reflection.instancevariables.retrieval.impl.tasks.privates.GetPrivateInstanceVariablesArrayTask;

public class ReflectionInstanceVariablesRetrievalServiceImpl extends ReflectionServiceObject implements ReflectionInstanceVariablesRetrievalService
{
    @Override
    public Field[] getDeclaredInstanceVariablesArray(Object object)
    {
        return GetDeclaredInstanceVariablesArrayTask.run(object);
    }


    @Override
    public Field[] getDeclaredInstanceVariablesArray(Class<?> aClass)
    {
        return GetDeclaredInstanceVariablesArrayTask.run(aClass);
    }


    @Override
    public List<Field> getDeclaredInstanceVariables(Object object)
    {
        return Arrays.asList(getDeclaredInstanceVariablesArray(object));
    }


    @Override
    public List<Field> getDeclaredInstanceVariables(Class<?> aClass)
    {
        return Arrays.asList(getDeclaredInstanceVariablesArray(aClass));
    }


    @Override
    public Field[] getPrivateInstanceVariablesArray(Object object)
    {
        return GetPrivateInstanceVariablesArrayTask.run(object);
    }


    @Override
    public Field[] getPrivateInstanceVariablesArray(Class<?> aClass)
    {
        return GetPrivateInstanceVariablesArrayTask.run(aClass);
    }


    @Override
    public List<Field> getPrivateInstanceVariables(Object object)
    {
        return Arrays.asList(getPrivateInstanceVariablesArray(object));
    }


    @Override
    public List<Field> getPrivateInstanceVariables(Class<?> aClass)
    {
        return Arrays.asList(getPrivateInstanceVariablesArray(aClass));
    }


    @Override
    public Field[] getDeclaredProtectedInstanceVariablesArray(Object object)
    {
        return GetDeclaredProtectedInstanceVariablesArrayTask.run(object);
    }


    @Override
    public Field[] getDeclaredProtectedInstanceVariablesArray(Class<?> aClass)
    {
        return GetDeclaredProtectedInstanceVariablesArrayTask.run(aClass);
    }


    @Override
    public List<Field> getDeclaredProtectedInstanceVariables(Object object)
    {
        return Arrays.asList(getDeclaredProtectedInstanceVariablesArray(object));
    }


    @Override
    public List<Field> getDeclaredProtectedInstanceVariables(Class<?> aClass)
    {
        return Arrays.asList(getDeclaredProtectedInstanceVariablesArray(aClass));
    }


    @Override
    public Field[] getDeclaredPublicInstanceVariablesArray(Object object)
    {
        return GetDeclaredPublicInstanceVariablesArrayTask.run(object);
    }


    @Override
    public Field[] getDeclaredPublicInstanceVariablesArray(Class<?> aClass)
    {
        return GetDeclaredPublicInstanceVariablesArrayTask.run(aClass);
    }


    @Override
    public List<Field> getDeclaredPublicInstanceVariables(Object object)
    {
        return Arrays.asList(getDeclaredPublicInstanceVariablesArray(object));
    }


    @Override
    public List<Field> getDeclaredPublicInstanceVariables(Class<?> aClass)
    {
        return Arrays.asList(getDeclaredPublicInstanceVariablesArray(aClass));
    }


    @Override
    public Field[] getInherittedInstanceVariablesArray(Object object)
    {
        return GetInherittedInstanceVariablesArrayTask.run(object);
    }


    @Override
    public Field[] getInherittedInstanceVariablesArray(Class<?> aClass)
    {
        return GetInherittedInstanceVariablesArrayTask.run(aClass);
    }


    @Override
    public List<Field> getInherittedInstanceVariables(Object object)
    {
        return Arrays.asList(getInherittedInstanceVariablesArray(object));
    }


    @Override
    public List<Field> getInherittedInstanceVariables(Class<?> aClass)
    {
        return Arrays.asList(getInherittedInstanceVariablesArray(aClass));
    }


    @Override
    public Field[] getAllInstanceVariablesArray(Object object)
    {
        return GetAllInstanceVariablesArrayTask.run(object);
    }


    @Override
    public Field[] getAllInstanceVariablesArray(Class<?> aClass)
    {
        return GetAllInstanceVariablesArrayTask.run(aClass);
    }


    @Override
    public List<Field> getAllInstanceVariables(Object object)
    {
        return Arrays.asList(getAllInstanceVariablesArray(object));
    }


    @Override
    public List<Field> getAllInstanceVariables(Class<?> aClass)
    {
        return Arrays.asList(getAllInstanceVariablesArray(aClass));
    }
}
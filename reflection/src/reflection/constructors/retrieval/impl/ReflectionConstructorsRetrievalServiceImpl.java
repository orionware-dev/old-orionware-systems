package reflection.constructors.retrieval.impl;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import reflection.ReflectionServiceObject;
import reflection.constructors.retrieval.ReflectionConstructorsRetrievalService;
import reflection.constructors.retrieval.impl.tasks.declared.GetDeclaredConstructorsArrayTask;
import reflection.constructors.retrieval.impl.tasks.publics.GetPublicConstructorsArrayTask;

public class ReflectionConstructorsRetrievalServiceImpl extends ReflectionServiceObject implements ReflectionConstructorsRetrievalService
{
    @Override
    public Constructor<?>[] getDeclaredConstructorsArray(Object object)
    {
        return GetDeclaredConstructorsArrayTask.run(object);
    }

    
    @Override
    public Constructor<?>[] getDeclaredConstructorsArray(Class<?> aClass)
    {
        return GetDeclaredConstructorsArrayTask.run(aClass);
    }

    
    @Override
    public List<Constructor<?>> getDeclaredConstructors(Object object)
    {
        return Arrays.asList(getDeclaredConstructorsArray(object));
    }

    
    @Override
    public List<Constructor<?>> getDeclaredConstructors(Class<?> aClass)
    {
        return Arrays.asList(getDeclaredConstructorsArray(aClass));
    }


    @Override
    public Constructor<?>[] getPublicConstructorsArray(Object object)
    {
        return GetPublicConstructorsArrayTask.run(object);
    }


    @Override
    public Constructor<?>[] getPublicConstructorsArray(Class<?> aClass)
    {
        return GetPublicConstructorsArrayTask.run(aClass);
    }


    @Override
    public List<Constructor<?>> getPublicConstructors(Object object)
    {
        return Arrays.asList(getPublicConstructorsArray(object));
    }


    @Override
    public List<Constructor<?>> getPublicConstructors(Class<?> aClass)
    {
        return Arrays.asList(getPublicConstructorsArray(aClass));
    }
}
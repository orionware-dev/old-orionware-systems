package reflection.constructors.retrieval.impl;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import reflection.ReflectionServiceObject;
import reflection.constructors.retrieval.ReflectionConstructorsRetrievalService;
import reflection.constructors.retrieval.impl.tasks.GetDeclaredConstructorsArrayTask;
import reflection.constructors.retrieval.impl.tasks.GetPublicConstructorsArrayTask;

public class ReflectionConstructorsRetrievalServiceImpl extends ReflectionServiceObject implements ReflectionConstructorsRetrievalService
{
    @Override
    public Constructor<?>[] getDeclaredConstructorsArray(Object object)
    {
        return new GetDeclaredConstructorsArrayTask().run(object);
    }

    
    @Override
    public Constructor<?>[] getDeclaredConstructorsArray(Class<?> aClass)
    {
        return new GetDeclaredConstructorsArrayTask().run(aClass);
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
        return new GetPublicConstructorsArrayTask().run(object);
    }


    @Override
    public Constructor<?>[] getPublicConstructorsArray(Class<?> aClass)
    {
        return new GetPublicConstructorsArrayTask().run(aClass);
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
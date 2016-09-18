package reflection.constructors.retrieval.impl;

import java.lang.reflect.Constructor;
import reflection.ReflectionServiceObject;
import reflection.constructors.retrieval.ReflectionConstructorRetrievalService;
import reflection.constructors.retrieval.impl.tasks.declared.GetDeclaredConstructorTask;
import reflection.constructors.retrieval.impl.tasks.publics.GetPublicConstructorTask;

public class ReflectionConstructorRetrievalServiceImpl extends ReflectionServiceObject implements ReflectionConstructorRetrievalService
{
    @Override
    public Constructor<?> getDeclaredConstructor(Object object, Class<?>... constructorParameterTypes)
    {
        return GetDeclaredConstructorTask.run(object, constructorParameterTypes);
    }

    
    @Override
    public Constructor<?> getDeclaredConstructor(Class<?> aClass, Class<?>... constructorParameterTypes)
    {
        return GetDeclaredConstructorTask.run(aClass, constructorParameterTypes);
    }


    @Override
    public Constructor<?> getPublicConstructor(Object object, Class<?>... constructorParameterTypes)
    {
        return GetPublicConstructorTask.run(object, constructorParameterTypes);
    }


    @Override
    public Constructor<?> getPublicConstructor(Class<?> aClass, Class<?>... constructorParameterTypes)
    {
        return GetPublicConstructorTask.run(aClass, constructorParameterTypes);
    }
}
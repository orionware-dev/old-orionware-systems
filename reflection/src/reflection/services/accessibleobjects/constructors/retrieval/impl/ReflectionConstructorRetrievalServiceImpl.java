package reflection.services.accessibleobjects.constructors.retrieval.impl;

import java.lang.reflect.Constructor;
import reflection.services.ReflectionServiceObject;
import reflection.services.accessibleobjects.constructors.retrieval.ReflectionConstructorRetrievalService;
import reflection.services.accessibleobjects.constructors.retrieval.impl.tasks.GetDeclaredConstructorTask;
import reflection.services.accessibleobjects.constructors.retrieval.impl.tasks.GetPublicConstructorTask;

public class ReflectionConstructorRetrievalServiceImpl extends ReflectionServiceObject implements ReflectionConstructorRetrievalService
{
    @Override
    public Constructor<?> getDeclaredConstructor(Object object, Class<?>... constructorParameterTypes)
    {
        return new GetDeclaredConstructorTask().run(object, constructorParameterTypes);
    }

    
    @Override
    public Constructor<?> getDeclaredConstructor(Class<?> aClass, Class<?>... constructorParameterTypes)
    {
        return new GetDeclaredConstructorTask().run(aClass, constructorParameterTypes);
    }


    @Override
    public Constructor<?> getPublicConstructor(Object object, Class<?>... constructorParameterTypes)
    {
        return new GetPublicConstructorTask().run(object, constructorParameterTypes);
    }


    @Override
    public Constructor<?> getPublicConstructor(Class<?> aClass, Class<?>... constructorParameterTypes)
    {
        return new GetPublicConstructorTask().run(aClass, constructorParameterTypes);
    }
}
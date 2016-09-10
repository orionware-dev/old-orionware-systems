package reflection.services.accessibleobjects.constructors.impl;

import java.lang.reflect.Constructor;
import reflection.services.ReflectionServiceObject;
import reflection.services.accessibleobjects.constructors.ReflectionConstructorsService;
import reflection.services.accessibleobjects.constructors.impl.tasks.CallConstructorTask;
import reflection.services.accessibleobjects.constructors.impl.tasks.GetConstructorsArrayTask;

public class ReflectionConstructorsServiceImpl extends ReflectionServiceObject implements ReflectionConstructorsService
{
    @Override
    public Constructor<?>[] getConstructorsArray(Object object)
    {
        return new GetConstructorsArrayTask().run(object);
    }
    
    
    @Override
    public Constructor<?>[] getConstructorsArray(Class<?> aClass)
    {
        return new GetConstructorsArrayTask().run(aClass);
    }


    @Override
    public void callConstructor(Constructor<?> constructor, Object... constructorArguments)
    {
        new CallConstructorTask().run(constructor, constructorArguments);
    }
}
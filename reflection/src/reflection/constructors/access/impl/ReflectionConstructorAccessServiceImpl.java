package reflection.constructors.access.impl;

import java.lang.reflect.Constructor;
import reflection.ReflectionServiceObject;
import reflection.constructors.access.ReflectionConstructorAccessService;
import reflection.constructors.access.impl.tasks.CallConstructorTask;

public class ReflectionConstructorAccessServiceImpl extends ReflectionServiceObject implements ReflectionConstructorAccessService
{
    @Override
    public void callConstructor(Constructor<?> constructor, Object... constructorArguments)
    {
        new CallConstructorTask().run(constructor, constructorArguments);
    }
}
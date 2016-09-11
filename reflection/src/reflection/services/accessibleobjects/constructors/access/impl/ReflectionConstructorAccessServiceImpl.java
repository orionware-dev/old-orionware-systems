package reflection.services.accessibleobjects.constructors.access.impl;

import java.lang.reflect.Constructor;
import reflection.services.ReflectionServiceObject;
import reflection.services.accessibleobjects.constructors.access.ReflectionConstructorAccessService;
import reflection.services.accessibleobjects.constructors.access.impl.tasks.CallConstructorTask;

public class ReflectionConstructorAccessServiceImpl extends ReflectionServiceObject implements ReflectionConstructorAccessService
{
    @Override
    public void callConstructor(Constructor<?> constructor, Object... constructorArguments)
    {
        new CallConstructorTask().run(constructor, constructorArguments);
    }
}
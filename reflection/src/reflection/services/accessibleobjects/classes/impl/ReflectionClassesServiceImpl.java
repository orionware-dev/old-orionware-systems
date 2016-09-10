package reflection.services.accessibleobjects.classes.impl;

import reflection.services.ReflectionServiceObject;
import reflection.services.accessibleobjects.classes.ReflectionClassesService;
import reflection.services.accessibleobjects.classes.impl.tasks.InstantiateClassTask;
import reflection.services.accessibleobjects.classes.impl.tasks.LoadClassTask;

public class ReflectionClassesServiceImpl extends ReflectionServiceObject implements ReflectionClassesService
{
    @Override
    public Class<?> loadClass(String className)
    {
        return new LoadClassTask().run(className);
    }


    @Override
    public Object instantiateClass(Class<?> classToInstantiate, Class<?>... constructorArguments)
    {
        return new InstantiateClassTask().run(classToInstantiate, constructorArguments);
    }


    @Override
    public Object instantiateClass(String className, Class<?>... constructorArguments)
    {
        return instantiateClass(loadClass(className), constructorArguments);
    }
}
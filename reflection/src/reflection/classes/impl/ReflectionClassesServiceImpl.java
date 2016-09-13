package reflection.classes.impl;

import reflection.ReflectionServiceObject;
import reflection.classes.ReflectionClassesService;
import reflection.classes.impl.tasks.InstantiateClassTask;
import reflection.classes.impl.tasks.LoadClassTask;

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
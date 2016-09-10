package reflection.services.accessibleobjects.classes;

import reflection.ReflectionService;

public interface ReflectionClassesService extends ReflectionService
{
    public Class<?> loadClass(String className);


    public Object instantiateClass(Class<?> classToInstantiate, Class<?>... constructorArguments);


    public Object instantiateClass(String className, Class<?>... constructorArguments);
}
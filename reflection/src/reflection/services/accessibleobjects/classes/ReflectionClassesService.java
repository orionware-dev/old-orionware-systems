package reflection.services.accessibleobjects.classes;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import reflection.ReflectionService;

public interface ReflectionClassesService extends ReflectionService
{
    public Class<?> loadClass(String className);


    public Object instantiateClass(Class<?> classToInstantiate);


    public Object instantiateClass(String className);
}
package reflection.services.accessibleobjects.constructors.impl.tasks;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetInherittedConstructorsArrayTask extends ReflectionObject implements ReflectionTask
{
    public Constructor<?>[] run(Class<?> aClass)
    {
        List<Constructor<?>> allConstructors = Arrays.asList(aClass.getConstructors());
        List<Constructor<?>> declaredConstructors = Arrays.asList(aClass.getDeclaredConstructors());
        //these are the inheritted constructors only
        allConstructors.removeAll(declaredConstructors);
        return allConstructors.toArray(new Constructor[0]);
    }
    
    
    public Constructor<?>[] run(Object object)
    {
        return run(object.getClass());
    }
}
package reflection.services.accessibleobjects.methods.retrieval.impl.tasks;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Collectors;
import reflection.ReflectionObject;
import reflection.ReflectionTask;

public class GetDeclaredDefaultMethodsArrayTask extends ReflectionObject implements ReflectionTask
{
    public Method[] run(Class<?> aClass)
    {
        return Arrays.stream(aClass.getDeclaredMethods()).filter(method ->
                                                                         !Modifier.isPrivate(method.getModifiers())
                                                                         && !Modifier.isProtected(method.getModifiers())
                                                                         && !Modifier.isPublic(method.getModifiers()))
                     .collect(Collectors.toList()).toArray(new Method[0]);
    }
    
    
    public Method[] run(Object object)
    {
        return run(object.getClass());
    }
}
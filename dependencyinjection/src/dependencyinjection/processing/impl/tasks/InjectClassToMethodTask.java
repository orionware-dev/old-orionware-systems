package dependencyinjection.processing.impl.tasks;

import java.lang.reflect.Method;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import reflection.classes.impl.ReflectionClassesServiceImpl;

public class InjectClassToMethodTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    public void run(Object object, Class<?> classToInject, Method method)
    {
        Object objectToInject = new ReflectionClassesServiceImpl().instantiateClass(classToInject);
        new InjectObjectToMethodTask().run(object, objectToInject, method);
    }
    
    
    public void run(Object object, String classToInjectString, Method method)
    {
        Class<?> classToInject = new ReflectionClassesServiceImpl().loadClass(classToInjectString);
        run(object, classToInject, method);
    }
}
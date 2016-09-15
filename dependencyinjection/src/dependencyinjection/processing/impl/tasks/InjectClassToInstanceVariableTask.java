package dependencyinjection.processing.impl.tasks;

import java.lang.reflect.Field;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import reflection.classes.impl.ReflectionClassesServiceImpl;

public class InjectClassToInstanceVariableTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private InjectObjectToInstanceVariableTask injectObjectToInstanceVariableTask = new InjectObjectToInstanceVariableTask();
    
    
    public void run(Object object, Class<?> classToInject, Field instanceVariable)
    {
        Object objectToInject = new ReflectionClassesServiceImpl().instantiateClass(classToInject);
        injectObjectToInstanceVariableTask.run(object, objectToInject, instanceVariable);
    }
    
    
    public void run(Object object, String classToInjectString, Field instanceVariable)
    {
        Class<?> classToInject = new ReflectionClassesServiceImpl().loadClass(classToInjectString);
        run(object, classToInject, instanceVariable);
    }
}
package dependencyinjection.processing.impl.tasks.custom;

import java.lang.reflect.Method;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotation.Injector;
import dependencyinjection.processing.impl.tasks.classes.InjectClassToMethodTask;

public class ProcessCustomInjectionForMethodTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private InjectClassToMethodTask injectClassToMethodTask = new InjectClassToMethodTask();
    
    
    public void run(Object object, Injector injection, Method method)
    {
        if(injection != null)
        {
            String classToInjectString = injection.ID();
            injectClassToMethodTask.run(object, classToInjectString, method);
        }
    }
}
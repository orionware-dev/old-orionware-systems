package dependencyinjection.processing.impl.tasks;

import java.lang.reflect.Method;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotation.Injector;

public class ProcessCustomInjectionForMethodTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    public void run(Object object, Injector injection, Method method)
    {
        if(injection != null)
        {
            String classToInjectString = injection.ID();
            new InjectClassToMethodTask().run(object, classToInjectString, method);
        }
    }
}
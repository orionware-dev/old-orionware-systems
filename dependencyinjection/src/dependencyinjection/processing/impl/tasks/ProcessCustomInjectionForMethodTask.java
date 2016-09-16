package dependencyinjection.processing.impl.tasks;

import java.lang.reflect.Method;
import configuration.registry.impl.ConfigurationPropertiesServiceImpl;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotation.Injector;
import dependencyinjection.annotation.Prop;

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
    
    
    public void run(Object object, Prop propertyInjection, Method method)
    {
        if(propertyInjection != null)
        {
            String propertyToInjectString = propertyInjection.key();
            String propertyToInject = new ConfigurationPropertiesServiceImpl().getProp(propertyToInjectString);
            new InjectObjectToMethodTask().run(object, propertyToInject, method);
        }
    }
}
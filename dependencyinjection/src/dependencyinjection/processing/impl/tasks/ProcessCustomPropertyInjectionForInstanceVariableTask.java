package dependencyinjection.processing.impl.tasks;

import java.lang.reflect.Field;
import configuration.registry.impl.ConfigurationPropertiesServiceImpl;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotation.Injector;
import dependencyinjection.annotation.Prop;

public class ProcessCustomPropertyInjectionForInstanceVariableTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    public void run(Object object, Prop propertyInjection, Field instanceVariable)
    {
        if(propertyInjection != null)
        {
            String propertyToInjectString = propertyInjection.key();
            String propertyToInject = new ConfigurationPropertiesServiceImpl().getProp(propertyToInjectString);
            new InjectObjectToInstanceVariableTask().run(object, propertyToInject, instanceVariable);
        }
    }
}
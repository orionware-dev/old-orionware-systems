package dependencyinjection.processing.impl.tasks.custom;

import java.lang.reflect.Field;
import configuration.registry.ConfigurationRegistryService;
import configuration.registry.impl.ConfigurationRegistryServiceImpl;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotation.Prop;
import dependencyinjection.processing.impl.tasks.objects.InjectObjectToInstanceVariableTask;

public class ProcessCustomPropertyInjectionForInstanceVariableTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private ConfigurationRegistryService configurationRegistryService = new ConfigurationRegistryServiceImpl();
    
    
    public void run(Object object, Prop propertyInjection, Field instanceVariable)
    {
        if(propertyInjection != null)
        {
            String propertyToInjectString = propertyInjection.key();
            String propertyToInject = configurationRegistryService.getProp(propertyToInjectString);
            new InjectObjectToInstanceVariableTask().run(object, propertyToInject, instanceVariable);
        }
    }
}
package dependencyinjection.processing.impl.tasks.custom;

import java.lang.reflect.Method;
import configuration.registry.ConfigurationRegistryService;
import configuration.registry.impl.ConfigurationRegistryServiceImpl;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotation.Prop;
import dependencyinjection.processing.impl.tasks.objects.InjectObjectToMethodTask;

public class ProcessCustomPropertyInjectionForMethodTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private ConfigurationRegistryService configurationRegistryService = new ConfigurationRegistryServiceImpl();
    
    
    public void run(Object object, Prop propertyInjection, Method method)
    {
        if(propertyInjection != null)
        {
            String propertyToInjectString = propertyInjection.key();
            String propertyToInject = configurationRegistryService.getProp(propertyToInjectString);
            new InjectObjectToMethodTask().run(object, propertyToInject, method);
        }
    }
}
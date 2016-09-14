package dependencyinjection.processing.impl.tasks;

import java.lang.reflect.Method;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import reflection.methods.access.ReflectionMethodAccessService;
import reflection.methods.access.impl.ReflectionMethodAccessServiceImpl;

public class InjectObjectToMethodTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    public void run(Object object, Object objectToInject, Method method)
    {
        ReflectionMethodAccessService reflectionMethodAccessService = new ReflectionMethodAccessServiceImpl();
        reflectionMethodAccessService.makeMethodAccessible(method);
        reflectionMethodAccessService.callMethod(method, object, objectToInject);
    }
}
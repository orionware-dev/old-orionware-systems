package dependencyinjection.processing.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import dependencyinjection.DependencyInjectionServiceObject;
import dependencyinjection.annotation.Injector;
import dependencyinjection.processing.DependencyInjectorService;
import dependencyinjection.processing.impl.tasks.ProcessDependenciesTask;
import dependencyinjection.processing.impl.tasks.classes.InjectClassToInstanceVariableTask;
import dependencyinjection.processing.impl.tasks.classes.InjectClassToMethodTask;
import dependencyinjection.processing.impl.tasks.custom.ProcessCustomInjectionForInstanceVariableTask;
import dependencyinjection.processing.impl.tasks.custom.ProcessCustomInjectionForMethodTask;
import dependencyinjection.processing.impl.tasks.objects.InjectObjectToInstanceVariableTask;
import dependencyinjection.processing.impl.tasks.objects.InjectObjectToMethodTask;

public class DependencyInjectorServiceImpl extends DependencyInjectionServiceObject implements DependencyInjectorService
{
    @Override
    public void processDependencies(Object object)
    {
        new ProcessDependenciesTask().run(object);
    }

    
    @Override
    public void processCustomInjectionForInstanceVariable(Object object, Injector injection, Field instanceVariable)
    {
        new ProcessCustomInjectionForInstanceVariableTask().run(object, injection, instanceVariable);
    }
    
    
    @Override
    public void processCustomInjectionForMethod(Object object, Injector injection, Method method)
    {
        new ProcessCustomInjectionForMethodTask().run(object, injection, method);
    }


    @Override
    public void injectObjectToMethod(Object object, Object objectToInject, Method method)
    {
        new InjectObjectToMethodTask().run(object, objectToInject, method);
    }


    @Override
    public void injectClassToMethod(Object object, Class<?> classToInject, Method method)
    {
        new InjectClassToMethodTask().run(object, classToInject, method);
    }
    
    
    @Override
    public void injectClassToMethod(Object object, String classToInjectString, Method method)
    {
        new InjectClassToMethodTask().run(object, classToInjectString, method);
    }


    @Override
    public void injectObjectToInstanceVariable(Object object, Object objectToInject, Field instanceVariable)
    {
        new InjectObjectToInstanceVariableTask().run(object, objectToInject, instanceVariable);
    }


    @Override
    public void injectClassToInstanceVariable(Object object, Class<?> classToInject, Field instanceVariable)
    {
        new InjectClassToInstanceVariableTask().run(object, classToInject, instanceVariable);
    }
    
    
    @Override
    public void injectClassToInstanceVariable(Object object, String classToInjectString, Field instanceVariable)
    {
        new InjectClassToInstanceVariableTask().run(object, classToInjectString, instanceVariable);
    }
}
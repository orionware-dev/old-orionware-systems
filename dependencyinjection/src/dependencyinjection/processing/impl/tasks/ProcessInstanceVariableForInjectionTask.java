package dependencyinjection.processing.impl.tasks;

import java.lang.reflect.Field;
import annotations.gathering.impl.AnnotationsGatheringServiceImpl;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotation.Injector;

public class ProcessInstanceVariableForInjectionTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    public void run(Object object, Field instanceVariable)
    {
        Injector injection = (Injector)new AnnotationsGatheringServiceImpl().extractAnnotationFromInstanceVariable(instanceVariable, Injector.class);
        new ProcessCustomInjectionForInstanceVariableTask().run(object, injection, instanceVariable);
    }
}
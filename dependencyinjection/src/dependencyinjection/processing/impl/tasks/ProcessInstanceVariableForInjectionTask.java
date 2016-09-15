package dependencyinjection.processing.impl.tasks;

import java.lang.reflect.Field;
import annotations.gathering.AnnotationsGatheringService;
import annotations.gathering.impl.AnnotationsGatheringServiceImpl;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotation.Injector;

public class ProcessInstanceVariableForInjectionTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private static AnnotationsGatheringService annotationsGatheringService = new AnnotationsGatheringServiceImpl();
    private static ProcessCustomInjectionForInstanceVariableTask processCustomInjectionForInstanceVariableTask = new ProcessCustomInjectionForInstanceVariableTask();
    
    
    public void run(Object object, Field instanceVariable)
    {
        Injector injection = (Injector)annotationsGatheringService.extractAnnotationFromInstanceVariable(instanceVariable, Injector.class);
        processCustomInjectionForInstanceVariableTask.run(object, injection, instanceVariable);
    }
}
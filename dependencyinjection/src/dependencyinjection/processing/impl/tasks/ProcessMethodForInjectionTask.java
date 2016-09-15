package dependencyinjection.processing.impl.tasks;

import java.lang.reflect.Method;
import annotations.gathering.AnnotationsGatheringService;
import annotations.gathering.impl.AnnotationsGatheringServiceImpl;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotation.Injector;

public class ProcessMethodForInjectionTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private static AnnotationsGatheringService annotationsGatheringService = new AnnotationsGatheringServiceImpl();
    private ProcessCustomInjectionForMethodTask processCustomInjectionForMethodTask = new ProcessCustomInjectionForMethodTask();
    
    
    public void run(Object object, Method method)
    {
        Injector injection = (Injector)annotationsGatheringService.extractAnnotationFromMethod(method, Injector.class);
        processCustomInjectionForMethodTask.run(object, injection, method);
    }
}
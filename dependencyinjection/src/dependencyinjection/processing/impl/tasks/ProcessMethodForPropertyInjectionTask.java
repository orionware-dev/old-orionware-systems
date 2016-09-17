package dependencyinjection.processing.impl.tasks;

import java.lang.reflect.Method;
import annotations.gathering.AnnotationsGatheringService;
import annotations.gathering.impl.AnnotationsGatheringServiceImpl;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotation.Prop;

public class ProcessMethodForPropertyInjectionTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private static AnnotationsGatheringService annotationsGatheringService = new AnnotationsGatheringServiceImpl();
    private ProcessCustomPropertyInjectionForMethodTask processCustomPropertyInjectionForMethodTask = new ProcessCustomPropertyInjectionForMethodTask();
    
    
    public void run(Object object, Method method)
    {
        Prop injection = (Prop)annotationsGatheringService.extractAnnotationFromMethod(method, Prop.class);
        processCustomPropertyInjectionForMethodTask.run(object, injection, method);
    }
}
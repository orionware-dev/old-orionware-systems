package dependencyinjection.processing.impl.tasks;

import java.lang.reflect.Field;
import annotations.gathering.AnnotationsGatheringService;
import annotations.gathering.impl.AnnotationsGatheringServiceImpl;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotation.Prop;

public class ProcessInstanceVariableForPropertyInjectionTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private static AnnotationsGatheringService annotationsGatheringService = new AnnotationsGatheringServiceImpl();
    private static ProcessCustomPropertyInjectionForInstanceVariableTask processCustomPropertyInjectionForInstanceVariableTask = new ProcessCustomPropertyInjectionForInstanceVariableTask();
    
    
    public void run(Object object, Field instanceVariable)
    {
        Prop injection = (Prop)annotationsGatheringService.extractAnnotationFromInstanceVariable(instanceVariable, Prop.class);
        processCustomPropertyInjectionForInstanceVariableTask.run(object, injection, instanceVariable);
    }
}
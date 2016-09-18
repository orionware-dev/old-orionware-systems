package dependencyinjection.processing.impl.tasks.instancevariables;

import java.lang.reflect.Field;
import annotations.extraction.AnnotationsExtractionService;
import annotations.extraction.impl.AnnotationsExtractionServiceImpl;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotation.Injector;
import dependencyinjection.processing.impl.tasks.custom.ProcessCustomInjectionForInstanceVariableTask;

public class ProcessInstanceVariableForInjectionTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private static AnnotationsExtractionService annotationsExtractionService = new AnnotationsExtractionServiceImpl();
    private static ProcessCustomInjectionForInstanceVariableTask processCustomInjectionForInstanceVariableTask = new ProcessCustomInjectionForInstanceVariableTask();
    
    
    public void run(Object object, Field instanceVariable)
    {
        Injector injection = (Injector)annotationsExtractionService.extractAnnotationFromInstanceVariable(instanceVariable, Injector.class);
        processCustomInjectionForInstanceVariableTask.run(object, injection, instanceVariable);
    }
}
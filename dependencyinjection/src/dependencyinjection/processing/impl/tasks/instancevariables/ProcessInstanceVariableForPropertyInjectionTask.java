package dependencyinjection.processing.impl.tasks.instancevariables;

import java.lang.reflect.Field;
import annotations.extraction.AnnotationsExtractionService;
import annotations.extraction.impl.AnnotationsExtractionServiceImpl;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotation.Prop;
import dependencyinjection.processing.impl.tasks.custom.ProcessCustomPropertyInjectionForInstanceVariableTask;

public class ProcessInstanceVariableForPropertyInjectionTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private static AnnotationsExtractionService annotationsExtractionService = new AnnotationsExtractionServiceImpl();
    private static ProcessCustomPropertyInjectionForInstanceVariableTask processCustomPropertyInjectionForInstanceVariableTask = new ProcessCustomPropertyInjectionForInstanceVariableTask();
    
    
    public void run(Object object, Field instanceVariable)
    {
        Prop injection = (Prop)annotationsExtractionService.extractAnnotationFromInstanceVariable(instanceVariable, Prop.class);
        processCustomPropertyInjectionForInstanceVariableTask.run(object, injection, instanceVariable);
    }
}
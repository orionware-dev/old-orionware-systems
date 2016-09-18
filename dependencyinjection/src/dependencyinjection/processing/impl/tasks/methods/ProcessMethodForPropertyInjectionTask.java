package dependencyinjection.processing.impl.tasks.methods;

import java.lang.reflect.Method;
import annotations.extraction.AnnotationsExtractionService;
import annotations.extraction.impl.AnnotationsExtractionServiceImpl;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotation.Prop;
import dependencyinjection.processing.impl.tasks.custom.ProcessCustomPropertyInjectionForMethodTask;

public class ProcessMethodForPropertyInjectionTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private static AnnotationsExtractionService annotationsExtractionService = new AnnotationsExtractionServiceImpl();
    private ProcessCustomPropertyInjectionForMethodTask processCustomPropertyInjectionForMethodTask = new ProcessCustomPropertyInjectionForMethodTask();
    
    
    public void run(Object object, Method method)
    {
        Prop injection = (Prop)annotationsExtractionService.extractAnnotationFromMethod(method, Prop.class);
        processCustomPropertyInjectionForMethodTask.run(object, injection, method);
    }
}
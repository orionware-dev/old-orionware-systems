package dependencyinjection.processing.impl.tasks.methods;

import java.lang.reflect.Method;
import annotations.extraction.AnnotationsExtractionService;
import annotations.extraction.impl.AnnotationsExtractionServiceImpl;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotation.Injector;
import dependencyinjection.processing.impl.tasks.custom.ProcessCustomInjectionForMethodTask;

public class ProcessMethodForInjectionTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private static AnnotationsExtractionService annotationsExtractionService = new AnnotationsExtractionServiceImpl();
    private ProcessCustomInjectionForMethodTask processCustomInjectionForMethodTask = new ProcessCustomInjectionForMethodTask();
    
    
    public void run(Object object, Method method)
    {
        Injector injection = (Injector)annotationsExtractionService.extractAnnotationFromMethod(method, Injector.class);
        processCustomInjectionForMethodTask.run(object, injection, method);
    }
}
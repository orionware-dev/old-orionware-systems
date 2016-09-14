package dependencyinjection.processing.impl.tasks;

import java.lang.reflect.Method;
import annotations.gathering.impl.AnnotationsGatheringServiceImpl;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotation.Injector;

public class ProcessMethodForInjectionTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    public void run(Object object, Method method)
    {
        Injector injection = (Injector)new AnnotationsGatheringServiceImpl().extractAnnotationFromMethod(method, Injector.class);
        new ProcessCustomInjectionForMethodTask().run(object, injection, method);
    }
}
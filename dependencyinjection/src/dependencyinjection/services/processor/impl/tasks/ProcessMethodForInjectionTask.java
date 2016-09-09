package dependencyinjection.services.processor.impl.tasks;

import java.lang.reflect.Method;
import annotations.services.gathering.AnnotationsGatheringService;
import annotations.services.gathering.impl.AnnotationsGatheringServiceImpl;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotations.Injector;
import reflection.services.loader.ReflectionLoaderService;
import reflection.services.loader.impl.ReflectionLoaderServiceImpl;

public class ProcessMethodForInjectionTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private Object object;
    private ReflectionLoaderService reflectionLoaderService;


    public ProcessMethodForInjectionTask()
    {
        this.reflectionLoaderService = new ReflectionLoaderServiceImpl();
    }


    public void run(Object object, Method method)
    {
        this.object = object;
        reflectionLoaderService.makeMethodAccessible(method);
        AnnotationsGatheringService annotationsGatheringService = new AnnotationsGatheringServiceImpl();
        Injector injection = (Injector)annotationsGatheringService.extractAnnotationFromMethod(method, Injector.class);
        
        if(injection != null)
        {
            processInjection(method, injection);
        }
    }


    private void processInjection(Method method, Injector injection)
    {
        String classToInjectString = injection.ID();
        Class<?> classToInject = reflectionLoaderService.loadClass(classToInjectString);
        reflectionLoaderService.callMethod(method, object, reflectionLoaderService.instantiateClass(classToInject));
    }
}
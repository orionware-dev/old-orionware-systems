package dependencyinjection.services.processor.impl.tasks;

import java.lang.reflect.Method;
import annotations.services.gathering.AnnotationsGatheringService;
import annotations.services.gathering.impl.AnnotationsGatheringServiceImpl;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotations.Injector;
import reflection.services.accessibleobjects.classes.ReflectionClassesService;
import reflection.services.accessibleobjects.classes.impl.ReflectionClassesServiceImpl;
import reflection.services.accessibleobjects.methods.ReflectionMethodsService;
import reflection.services.accessibleobjects.methods.impl.ReflectionMethodsServiceImpl;

public class ProcessMethodForInjectionTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private Object object;
    private ReflectionMethodsService reflectionMethodsService;
    private ReflectionClassesService reflectionClassesService;


    public ProcessMethodForInjectionTask()
    {
        this.reflectionMethodsService = new ReflectionMethodsServiceImpl();
        this.reflectionClassesService = new ReflectionClassesServiceImpl();
    }


    public void run(Object object, Method method)
    {
        this.object = object;
        reflectionMethodsService.makeMethodAccessible(method);
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
        Class<?> classToInject = reflectionClassesService.loadClass(classToInjectString);
        reflectionMethodsService.callMethod(method, object, reflectionClassesService.instantiateClass(classToInject));
    }
}
package dependencyinjection.processing.impl.tasks;

import java.lang.reflect.Method;
import annotations.gathering.impl.AnnotationsGatheringServiceImpl;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotation.Injector;
import reflection.classes.ReflectionClassesService;
import reflection.classes.impl.ReflectionClassesServiceImpl;
import reflection.methods.access.ReflectionMethodAccessService;
import reflection.methods.access.impl.ReflectionMethodAccessServiceImpl;

public class ProcessMethodForInjectionTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private Object object;
    private Method method;
    private ReflectionMethodAccessService reflectionMethodAccessService;
    ReflectionClassesService reflectionClassesService;


    public ProcessMethodForInjectionTask()
    {
        this.reflectionMethodAccessService = new ReflectionMethodAccessServiceImpl();
        this.reflectionClassesService = new ReflectionClassesServiceImpl();
    }


    public void run(Object object, Method method)
    {
        this.object = object;
        this.method = method;
        reflectionMethodAccessService.makeMethodAccessible(method);
        Injector injection = (Injector)new AnnotationsGatheringServiceImpl().extractAnnotationFromMethod(method, Injector.class);

        if(injection != null)
        {
            processInjection(injection);
        }
    }


    private void processInjection(Injector injection)
    {
        String classToInjectString = injection.ID();
        Class<?> classToInject = reflectionClassesService.loadClass(classToInjectString);
        reflectionMethodAccessService.callMethod(method, object, reflectionClassesService.instantiateClass(classToInject));
    }
}
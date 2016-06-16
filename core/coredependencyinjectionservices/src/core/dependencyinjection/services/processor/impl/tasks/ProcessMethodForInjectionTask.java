package core.dependencyinjection.services.processor.impl.tasks;

import java.lang.reflect.Method;
import core.annotations.facades.gathering.AnnotationsGatheringFacade;
import core.annotations.facades.gathering.impl.AnnotationsGatheringFacadeImpl;
import core.dependencyinjection.DependencyInjectionObject;
import core.dependencyinjection.DependencyInjectionTask;
import core.dependencyinjection.annotations.Injector;
import core.reflection.facades.loader.ReflectionLoaderFacade;
import core.reflection.facades.loader.impl.ReflectionLoaderFacadeImpl;

public class ProcessMethodForInjectionTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private Object object;
    private ReflectionLoaderFacade reflectionLoaderFacade;


    public ProcessMethodForInjectionTask()
    {
        this.reflectionLoaderFacade = new ReflectionLoaderFacadeImpl();
    }


    public void run(Object object, Method method)
    {
        this.object = object;
        reflectionLoaderFacade.makeMethodAccessible(method);
        AnnotationsGatheringFacade annotationsGatheringFacade = new AnnotationsGatheringFacadeImpl();
        Injector injection = (Injector)annotationsGatheringFacade.extractAnnotationFromMethod(method, Injector.class);
        
        if(injection != null)
        {
            processInjection(method, injection);
        }
    }


    private void processInjection(Method method, Injector injection)
    {
        String classToInjectString = injection.ID();
        Class<?> classToInject = reflectionLoaderFacade.loadClass(classToInjectString);
        reflectionLoaderFacade.callMethod(method, object, reflectionLoaderFacade.instantiateClass(classToInject));
    }
}
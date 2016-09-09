package dependencyinjection.services.processor.impl.tasks;

import java.lang.reflect.Method;
import annotations.services.gathering.AnnotationsGatheringService;
import annotations.services.gathering.impl.AnnotationsGatheringServiceImpl;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotations.InjectorImpl;
import reflection.services.loader.ReflectionLoaderService;
import reflection.services.loader.impl.ReflectionLoaderServiceImpl;

public class ProcessMethodForInjectionImplTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private Object object;
    private ReflectionLoaderService reflectionLoaderService;


    public ProcessMethodForInjectionImplTask()
    {
        this.reflectionLoaderService = new ReflectionLoaderServiceImpl();
    }


    public void run(Object object, Method method)
    {
        this.object = object;
        reflectionLoaderService.makeMethodAccessible(method);
        AnnotationsGatheringService annotationsGatheringService = new AnnotationsGatheringServiceImpl();
        InjectorImpl injection = (InjectorImpl)annotationsGatheringService.extractAnnotationFromMethod(method, InjectorImpl.class);
        
        if(injection != null)
        {
            processInjection(method, injection);
        }
    }


    private void processInjection(Method method, InjectorImpl injection)
    {
        Class<?>[] methodParameterTypes = method.getParameterTypes();
        
        if(methodParameterTypes.length > 0)
        {
            String classToInjectString = methodParameterTypes[0].getName();
            String className = classToInjectString.substring(classToInjectString.lastIndexOf(".") + 1);
            classToInjectString = classToInjectString.substring(0, classToInjectString.lastIndexOf("."));
            classToInjectString += ".impl." + className + "Impl";
            Class<?> classToInject = reflectionLoaderService.loadClass(classToInjectString);
            reflectionLoaderService.callMethod(method, object, reflectionLoaderService.instantiateClass(classToInject));
        }
    }
}
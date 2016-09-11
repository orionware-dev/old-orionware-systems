package dependencyinjection.services.processor.impl.tasks;

import java.lang.reflect.Method;
import annotations.services.gathering.AnnotationsGatheringService;
import annotations.services.gathering.impl.AnnotationsGatheringServiceImpl;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotations.InjectorImpl;
import reflection.services.accessibleobjects.classes.ReflectionClassesService;
import reflection.services.accessibleobjects.classes.impl.ReflectionClassesServiceImpl;
import reflection.services.accessibleobjects.methods.ReflectionMethodsService;
import reflection.services.accessibleobjects.methods.access.ReflectionMethodAccessService;
import reflection.services.accessibleobjects.methods.access.impl.ReflectionMethodAccessServiceImpl;
import reflection.services.accessibleobjects.methods.impl.ReflectionMethodsServiceImpl;

public class ProcessMethodForInjectionImplTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private Object object;
    private ReflectionMethodAccessService reflectionMethodAccessService;
    private ReflectionClassesService reflectionClassesService;


    public ProcessMethodForInjectionImplTask()
    {
        this.reflectionMethodAccessService = new ReflectionMethodAccessServiceImpl();
        this.reflectionClassesService = new ReflectionClassesServiceImpl();
    }


    public void run(Object object, Method method)
    {
        this.object = object;
        reflectionMethodAccessService.makeMethodAccessible(method);
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
            Class<?> classToInject = reflectionClassesService.loadClass(classToInjectString);
            reflectionMethodAccessService.callMethod(method, object, reflectionClassesService.instantiateClass(classToInject));
        }
    }
}
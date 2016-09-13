package dependencyinjection.processing.impl.tasks;

import java.lang.reflect.Method;
import annotations.gathering.impl.AnnotationsGatheringServiceImpl;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotation.InjectorImpl;
import reflection.classes.ReflectionClassesService;
import reflection.classes.impl.ReflectionClassesServiceImpl;
import reflection.methods.access.ReflectionMethodAccessService;
import reflection.methods.access.impl.ReflectionMethodAccessServiceImpl;

public class ProcessMethodForInjectionImplTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private static final String IMPL_PACKAGE = ".impl.";
    private static final String IMPL_CLASS_NAME_SUFFIX = "Impl";
    private Object object;
    private Method method;
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
        this.method = method;
        reflectionMethodAccessService.makeMethodAccessible(method);
        InjectorImpl injection = (InjectorImpl)new AnnotationsGatheringServiceImpl().extractAnnotationFromMethod(method, InjectorImpl.class);
        
        if(injection != null)
        {
            processInjection(injection);
        }
    }


    private void processInjection(InjectorImpl injection)
    {
        Class<?>[] methodParameterTypes = method.getParameterTypes();
        
        if(methodParameterTypes.length > 0)
        {
            String classToInjectString = methodParameterTypes[0].getName();
            int indexOfLastDot = classToInjectString.lastIndexOf(".");
            String className = classToInjectString.substring(indexOfLastDot + 1);
            classToInjectString = classToInjectString.substring(0, indexOfLastDot);
            StringBuilder sb = new StringBuilder(classToInjectString).append(IMPL_PACKAGE).append(className).append(IMPL_CLASS_NAME_SUFFIX);
            classToInjectString = sb.toString();
            Object objectToInject = reflectionClassesService.instantiateClass(classToInjectString);
            reflectionMethodAccessService.callMethod(method, object, objectToInject);
        }
    }
}
package core.dependencyinjection.tasks;

import java.lang.reflect.Method;
import core.OrionObject;
import core.annotations.processor.AnnotationsProcessorService;
import core.dependencyinjection.Injector;
import core.reflection.ReflectionService;
import core.services.OrionTask;

public class ProcessMethodForInjectionTask implements OrionTask
{
    private OrionObject object;
    private ReflectionService reflectionService;
    private AnnotationsProcessorService annotationsProcessorService;
    
    
    public void run(OrionObject object, Method method, ReflectionService reflectionService, AnnotationsProcessorService annotationsProcessorService)
    {
        this.reflectionService = reflectionService;
        this.object = object;
        reflectionService.makeMethodAccessible(method);
        //Injector injection = extractAnnotationFromMethod(method);
        Injector injection = (Injector)annotationsProcessorService.extractAnnotationFromMethod(method, Injector.class);
        
        if(injection != null)
        {
            processInjection(method, injection);
        }
    }
    
    
    private void processInjection(Method method, Injector injection)
    {
        String classToInject = injection.ID();
        
        try
        {
            reflectionService.callMethod(method, object, Class.forName(classToInject).newInstance());
        }
        catch(InstantiationException exception)
        {
            exception.printStackTrace();
        }
        catch(IllegalAccessException exception)
        {
            exception.printStackTrace();
        }
        catch(ClassNotFoundException exception)
        {
            exception.printStackTrace();
        }
    }
}
package core.dependencyinjection.tasks;

import java.lang.reflect.Method;
import java.util.Arrays;
import core.OrionObject;
import core.dependencyinjection.Injector;
import core.reflection.ReflectionService;
import core.services.OrionTask;

public class ProcessDependenciesTask extends OrionTask
{
    private OrionObject object;
    private ReflectionService reflectionService;
    
    
    public Object execute(OrionObject object, ReflectionService reflectionService)
    {
        this.object = object;
        this.reflectionService = reflectionService;
        Arrays.stream(reflectionService.getMethodsArray(object))
            .forEach(this::processMethod);
        return null;
    }
    
    
    private void processMethod(Method method)
    {
        reflectionService.makeMethodAccessible(method);
        Injector injection = extractAnnotationFromMethod(method);
        
        if(injection != null)
        {
            processInjection(method, injection);
        }
    }
    
    
    private Injector extractAnnotationFromMethod(Method method)
    {
        return method.getAnnotation(Injector.class);
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
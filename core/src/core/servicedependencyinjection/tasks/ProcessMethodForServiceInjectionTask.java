package core.servicedependencyinjection.tasks;

import java.lang.reflect.Method;
import core.OrionObject;
import core.annotations.processor.AnnotationsProcessorService;
import core.reflection.ReflectionService;
import core.servicedependencyinjection.ServiceInjector;
import core.services.OrionTask;

public class ProcessMethodForServiceInjectionTask implements OrionTask
{
    private OrionObject object;
    private ReflectionService reflectionService;
    
    
    public void run(OrionObject object, Method method, ReflectionService reflectionService, AnnotationsProcessorService annotationsProcessorService)
    {
        this.reflectionService = reflectionService;
        this.object = object;
        reflectionService.makeMethodAccessible(method);
        ServiceInjector serviceInjection = (ServiceInjector)annotationsProcessorService.extractAnnotationFromMethod(method, ServiceInjector.class);
        
        if(serviceInjection != null)
        {
            processInjection(method, serviceInjection);
        }
    }
    
    
    private void processInjection(Method method, ServiceInjector serviceInjection)
    {
        //the format is package1.package2.services.servicename.ServiceInterface
        String classToInject = serviceInjection.ID();
        //we transform it to package1.package2.services.servicename.impl.ServiceInterfaceImpl
        String classNameToInject = classToInject.substring(classToInject.lastIndexOf(".") + 1);
        classToInject = classToInject.substring(0, classToInject.lastIndexOf("."));
        classToInject += ".impl." + classNameToInject + "Impl";
        
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
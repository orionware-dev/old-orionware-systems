package core.taskdependencyinjection.tasks;

import java.lang.reflect.Method;
import core.OrionObject;
import core.annotations.processor.AnnotationsProcessorService;
import core.reflection.ReflectionService;
import core.services.OrionTask;
import core.taskdependencyinjection.TaskInjector;

public class ProcessMethodForTaskInjectionTask implements OrionTask
{
    private OrionObject object;
    private ReflectionService reflectionService;
    
    
    public void run(OrionObject object, Method method, ReflectionService reflectionService, AnnotationsProcessorService annotationsProcessorService)
    {
        this.reflectionService = reflectionService;
        this.object = object;
        reflectionService.makeMethodAccessible(method);
        TaskInjector taskInjection = (TaskInjector)annotationsProcessorService.extractAnnotationFromMethod(method, TaskInjector.class);
        
        if(taskInjection != null)
        {
            processInjection(method, taskInjection);
        }
    }
    
    
    private void processInjection(Method method, TaskInjector taskInjection)
    {
        //the format is package1.package2.services.servicename.TaskClassName
        String classToInject = taskInjection.ID();
        //we transform it to package1.package2.services.servicename.impl.tasks.TaskClassName
        String classNameToInject = classToInject.substring(classToInject.lastIndexOf(".") + 1);
        classToInject = classToInject.substring(0, classToInject.lastIndexOf("."));
        classToInject += ".impl.tasks." + classNameToInject;
        
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
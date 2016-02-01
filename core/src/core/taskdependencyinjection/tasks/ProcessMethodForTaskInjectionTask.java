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
        //the format is either package1.package2.services.servicename.TaskClassName
        //or just ServiceTaskName. We check for the first and if the ID
        //does not have a "." then we assume it is just the task class name
        String classToInject = taskInjection.ID();
        
        if(classToInject.indexOf(".") != -1)
        {
            //we transform it to package1.package2.services.servicename.impl.tasks.TaskClassName
            String classNameToInject = classToInject.substring(classToInject.lastIndexOf(".") + 1);
            classToInject = classToInject.substring(0, classToInject.lastIndexOf("."));
            classToInject += ".impl.tasks." + classNameToInject;
        }
        else
        {
            String classNameThatHasThisMethod = method.getDeclaringClass().getName();
            classNameThatHasThisMethod = classNameThatHasThisMethod.substring(0, classNameThatHasThisMethod.lastIndexOf("."));
            classToInject = classNameThatHasThisMethod + ".tasks." + classToInject;
        }
        
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
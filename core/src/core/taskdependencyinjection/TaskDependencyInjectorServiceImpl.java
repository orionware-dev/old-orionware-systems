package core.taskdependencyinjection;

import core.OrionObject;
import core.annotations.processor.AnnotationsProcessorService;
import core.annotations.processor.AnnotationsProcessorServiceImpl;
import core.reflection.ReflectionService;
import core.reflection.ReflectionServiceImpl;
import core.servicedependencyinjection.tasks.ProcessMethodForServiceInjectionTask;
import core.servicedependencyinjection.tasks.ProcessServiceDependenciesTask;
import core.taskdependencyinjection.tasks.ProcessMethodForTaskInjectionTask;
import core.taskdependencyinjection.tasks.ProcessTaskDependenciesTask;

public class TaskDependencyInjectorServiceImpl implements TaskDependencyInjectorService
{
    private ProcessTaskDependenciesTask processTaskDependenciesTask = new ProcessTaskDependenciesTask();
    private ReflectionService reflectionService = new ReflectionServiceImpl();
    private ProcessMethodForTaskInjectionTask processMethodForTaskInjectionTask = new ProcessMethodForTaskInjectionTask();
    private AnnotationsProcessorService annotationsProcessorService = new AnnotationsProcessorServiceImpl();
    
    
    @Override
    public void processTaskDependencies(OrionObject object)
    {
        processTaskDependenciesTask.run(object, reflectionService, processMethodForTaskInjectionTask, annotationsProcessorService);
    }
}
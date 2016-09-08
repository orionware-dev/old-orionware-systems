package designpatterns.services.annotations.impl;

import core.dependencyinjection.annotations.Injector;
import designpatterns.DesignPatternsObject;
import designpatterns.services.annotations.EmptyFilterAnnotationService;
import designpatterns.services.annotations.impl.tasks.ProcessEmptyFilterAnnotationTask;

public class EmptyFilterAnnotationServiceImpl extends DesignPatternsObject implements EmptyFilterAnnotationService
{
    private ProcessEmptyFilterAnnotationTask processEmptyFilterAnnotationTask;
    
    
    public EmptyFilterAnnotationServiceImpl()
    {
        
    }

    
    @Override
    public void processEmptyFilterAnnotation(Object object)
    {
        processEmptyFilterAnnotationTask.run(object);
    }
    
    
    @Injector(ID = "designpatterns.services.annotations.impl.tasks.ProcessEmptyFilterAnnotationTask")
    private void setProcessEmptyFilterAnnotationTask(ProcessEmptyFilterAnnotationTask processEmptyFilterAnnotationTask)
    {
        this.processEmptyFilterAnnotationTask = processEmptyFilterAnnotationTask;
    }
}
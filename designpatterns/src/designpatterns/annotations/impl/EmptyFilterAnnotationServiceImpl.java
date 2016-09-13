package designpatterns.annotations.impl;

import designpatterns.DesignPatternsObject;
import designpatterns.annotations.EmptyFilterAnnotationService;
import designpatterns.annotations.impl.tasks.ProcessEmptyFilterAnnotationTask;

public class EmptyFilterAnnotationServiceImpl extends DesignPatternsObject implements EmptyFilterAnnotationService
{
    private ProcessEmptyFilterAnnotationTask processEmptyFilterAnnotationTask;
    
    
    public EmptyFilterAnnotationServiceImpl()
    {
        this.processEmptyFilterAnnotationTask = new ProcessEmptyFilterAnnotationTask();
    }

    
    @Override
    public void processEmptyFilterAnnotation(Object object)
    {
        processEmptyFilterAnnotationTask.run(object);
    }
}
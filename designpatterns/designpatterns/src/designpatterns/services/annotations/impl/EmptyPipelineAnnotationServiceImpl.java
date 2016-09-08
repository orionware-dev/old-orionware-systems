package designpatterns.services.annotations.impl;

import core.dependencyinjection.annotations.Injector;
import designpatterns.DesignPatternsObject;
import designpatterns.services.annotations.EmptyPipelineAnnotationService;
import designpatterns.services.annotations.impl.tasks.ProcessEmptyPipelineAnnotationTask;

public class EmptyPipelineAnnotationServiceImpl extends DesignPatternsObject implements EmptyPipelineAnnotationService
{
    private ProcessEmptyPipelineAnnotationTask processEmptyPipelineAnnotationTask;
    
    
    public EmptyPipelineAnnotationServiceImpl()
    {
        this.processEmptyPipelineAnnotationTask = new ProcessEmptyPipelineAnnotationTask();
    }

    
    @Override
    public void processEmptyPipelineAnnotation(Object object)
    {
        processEmptyPipelineAnnotationTask.run(object);
    }
}
package designpatterns.annotations.impl;

import designpatterns.DesignPatternsObject;
import designpatterns.annotations.EmptyPipelineAnnotationService;
import designpatterns.annotations.impl.tasks.ProcessEmptyPipelineAnnotationTask;

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
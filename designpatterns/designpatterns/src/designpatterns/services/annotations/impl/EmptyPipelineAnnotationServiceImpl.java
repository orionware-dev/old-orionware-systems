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
        
    }

    
    @Override
    public void processEmptyPipelineAnnotation(Object object)
    {
        processEmptyPipelineAnnotationTask.run(object);
    }
    
    
    @Injector(ID = "designpatterns.services.annotations.impl.tasks.ProcessEmptyPipelineAnnotationTask")
    private void setProcessEmptyPipelineAnnotationTask(ProcessEmptyPipelineAnnotationTask processEmptyPipelineAnnotationTask)
    {
        this.processEmptyPipelineAnnotationTask = processEmptyPipelineAnnotationTask;
    }
}
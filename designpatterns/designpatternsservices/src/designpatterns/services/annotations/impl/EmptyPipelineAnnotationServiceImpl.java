package designpatterns.services.annotations.impl;

import java.lang.reflect.Method;
import java.util.Arrays;
import core.annotations.facades.gathering.AnnotationsGatheringFacade;
import core.dependencyinjection.annotations.Injector;
import core.reflection.facades.loader.ReflectionLoaderFacade;
import designpatterns.annotations.EmptyFilter;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.services.DesignPatternsServicesObject;
import designpatterns.services.annotations.EmptyFilterAnnotationService;
import designpatterns.services.annotations.EmptyPipelineAnnotationService;
import designpatterns.services.annotations.impl.tasks.ProcessEmptyFilterAnnotationTask;
import designpatterns.services.annotations.impl.tasks.ProcessEmptyPipelineAnnotationTask;
import designpatterns.services.pipeline.PipelineFilterService;

public class EmptyPipelineAnnotationServiceImpl extends DesignPatternsServicesObject implements EmptyPipelineAnnotationService
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
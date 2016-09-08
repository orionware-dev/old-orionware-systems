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
import designpatterns.services.annotations.impl.tasks.ProcessEmptyFilterAnnotationTask;
import designpatterns.services.pipeline.PipelineFilterService;

public class EmptyFilterAnnotationServiceImpl extends DesignPatternsServicesObject implements EmptyFilterAnnotationService
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
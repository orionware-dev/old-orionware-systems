package designpatterns.annotations.impl;

import designpatterns.DesignPatternsObject;
import designpatterns.annotations.EmptyPipelineAnnotationService;
import designpatterns.annotations.impl.tasks.ProcessEmptyPipelineAnnotationTask;

public class EmptyPipelineAnnotationServiceImpl extends DesignPatternsObject implements EmptyPipelineAnnotationService
{
    @Override
    public void processEmptyPipelineAnnotation(Object object)
    {
        new ProcessEmptyPipelineAnnotationTask().run(object);
    }
}
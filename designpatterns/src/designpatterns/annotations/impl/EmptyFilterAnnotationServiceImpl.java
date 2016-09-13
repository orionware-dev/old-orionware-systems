package designpatterns.annotations.impl;

import designpatterns.DesignPatternsObject;
import designpatterns.annotations.EmptyFilterAnnotationService;
import designpatterns.annotations.impl.tasks.ProcessEmptyFilterAnnotationTask;

public class EmptyFilterAnnotationServiceImpl extends DesignPatternsObject implements EmptyFilterAnnotationService
{
    @Override
    public void processEmptyFilterAnnotation(Object object)
    {
        new ProcessEmptyFilterAnnotationTask().run(object);
    }
}
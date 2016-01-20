package core.annotations.processor;

import core.annotations.processor.tasks.ApplyAnnotationsTask;
import core.annotations.processor.tasks.GatherAllObjectAnnotationsTask;
import core.general.ObjectDependenciesBuilder;
import core.reflection.ReflectionServiceImpl;

public class AnnotationsProcessorServiceDependenciesBuilder extends ObjectDependenciesBuilder
{
    public void injectDependencies(AnnotationsProcessorServiceImpl object)
    {
        object.setGatherAllObjectAnnotationsTask(new GatherAllObjectAnnotationsTask());
        object.setApplyAnnotationsTask(new ApplyAnnotationsTask());
        object.setReflectionService(new ReflectionServiceImpl());
    }
}
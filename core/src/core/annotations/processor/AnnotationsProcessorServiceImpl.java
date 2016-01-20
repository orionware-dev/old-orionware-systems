package core.annotations.processor;

import java.lang.annotation.Annotation;
import java.util.List;
import core.OrionObject;
import core.annotations.processor.tasks.ApplyAnnotationsTask;
import core.annotations.processor.tasks.GatherAllObjectAnnotationsTask;
import core.reflection.ReflectionService;

public class AnnotationsProcessorServiceImpl implements AnnotationsProcessorService
{
    private GatherAllObjectAnnotationsTask gatherAllObjectAnnotationsTask;
    private ApplyAnnotationsTask applyAnnotationsTask;
    private ReflectionService reflectionService;
    
    
    public AnnotationsProcessorServiceImpl()
    {
        new AnnotationsProcessorServiceDependenciesBuilder().injectDependencies(this);
    }
    
    
    @Override
    public void processAllAnnotations(OrionObject OrionObject)
    {
        List<Annotation> allObjectAnnotationsList = gatherAllObjectAnnotationsTask.run(OrionObject);
        applyAnnotationsTask.run(this, OrionObject, allObjectAnnotationsList);
    }
    
    
    @Override
    public ReflectionService getReflectionService()
    {
        return reflectionService;
    }


    public void setGatherAllObjectAnnotationsTask(GatherAllObjectAnnotationsTask gatherAllObjectAnnotationsTask)
    {
        this.gatherAllObjectAnnotationsTask = gatherAllObjectAnnotationsTask;
    }


    public void setApplyAnnotationsTask(ApplyAnnotationsTask applyAnnotationsTask)
    {
        this.applyAnnotationsTask = applyAnnotationsTask;
    }


    public void setReflectionService(ReflectionService reflectionService)
    {
        this.reflectionService = reflectionService;
    }
}
package annotations.services.gathering.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.List;
import annotations.services.AnnotationServiceObject;
import annotations.services.gathering.AnnotationsGatheringService;
import annotations.services.gathering.impl.tasks.ExtractAnnotationFromMethodTask;
import annotations.services.gathering.impl.tasks.GatherAllAnnotationsFromObjectTask;
import annotations.services.gathering.impl.tasks.GatherClassLevelAnnotationsFromObjectTask;
import annotations.services.gathering.impl.tasks.GatherConstructorsAnnotationsFromObjectTask;
import annotations.services.gathering.impl.tasks.GatherInstanceVariablesAnnotationsFromObjectTask;
import annotations.services.gathering.impl.tasks.GatherMethodsAnnotationsFromObjectTask;
import annotations.services.gathering.impl.tasks.GatherObjectElementAnnotationsFromObjectTask;

public class AnnotationsGatheringServiceImpl extends AnnotationServiceObject implements AnnotationsGatheringService
{
    @Override
    public List<Annotation> gatherAllAnnotationsFromObject(Object orionObject)
    {
        return new GatherAllAnnotationsFromObjectTask().run(orionObject);
    }


    @SuppressWarnings("rawtypes")
    @Override
    public Annotation extractAnnotationFromMethod(Method method, Class annotationClassToExtract)
    {
        return new ExtractAnnotationFromMethodTask().run(method, annotationClassToExtract);
    }


    @Override
    public List<Annotation> gatherClassLevelAnnotationsFromObject(Object orionObject)
    {
        return new GatherClassLevelAnnotationsFromObjectTask().run(orionObject);
    }


    @Override
    public List<Annotation> gatherInstanceVariablesAnnotationsFromObject(Object orionObject)
    {
        return new GatherInstanceVariablesAnnotationsFromObjectTask().run(orionObject);
    }


    @Override
    public List<Annotation> gatherConstructorsAnnotationsFromObject(Object orionObject)
    {
        return new GatherConstructorsAnnotationsFromObjectTask().run(orionObject);
    }


    @Override
    public List<Annotation> gatherMethodsAnnotationsFromObject(Object orionObject)
    {
        return new GatherMethodsAnnotationsFromObjectTask().run(orionObject);
    }


    @Override
    public List<Annotation> gatherObjectElementAnnotationsFromObject(AccessibleObject objectElement)
    {
        return new GatherObjectElementAnnotationsFromObjectTask().run(objectElement);
    }
}
package core.annotations.services.gathering.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.List;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.gathering.AnnotationsGatheringService;
import core.annotations.services.gathering.impl.tasks.ExtractAnnotationFromMethodTask;
import core.annotations.services.gathering.impl.tasks.GatherAllAnnotationsFromObjectTask;
import core.annotations.services.gathering.impl.tasks.GatherClassLevelAnnotationsFromObjectTask;
import core.annotations.services.gathering.impl.tasks.GatherConstructorsAnnotationsFromObjectTask;
import core.annotations.services.gathering.impl.tasks.GatherInstanceVariablesAnnotationsFromObjectTask;
import core.annotations.services.gathering.impl.tasks.GatherMethodsAnnotationsFromObjectTask;
import core.annotations.services.gathering.impl.tasks.GatherObjectElementAnnotationsFromObjectTask;

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
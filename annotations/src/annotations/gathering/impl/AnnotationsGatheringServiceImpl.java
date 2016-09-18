package annotations.gathering.impl;

import java.lang.reflect.AnnotatedElement;
import java.util.List;
import annotations.AnnotationServiceObject;
import annotations.OrionAnnotation;
import annotations.gathering.AnnotationsGatheringService;
import annotations.gathering.impl.tasks.GatherAllAnnotationsFromObjectTask;
import annotations.gathering.impl.tasks.GatherAnnotationsFromInstanceElementTask;
import annotations.gathering.impl.tasks.GatherClassLevelAnnotationsFromObjectTask;
import annotations.gathering.impl.tasks.GatherConstructorsAnnotationsFromObjectTask;
import annotations.gathering.impl.tasks.GatherInstanceVariablesAnnotationsFromObjectTask;
import annotations.gathering.impl.tasks.GatherMethodsAnnotationsFromObjectTask;

public class AnnotationsGatheringServiceImpl extends AnnotationServiceObject implements AnnotationsGatheringService
{
    @Override
    public List<OrionAnnotation> gatherAllAnnotationsFromObject(Object object)
    {
        return GatherAllAnnotationsFromObjectTask.run(object);
    }


    @Override
    public List<OrionAnnotation> gatherClassLevelAnnotationsFromObject(Object object)
    {
        return GatherClassLevelAnnotationsFromObjectTask.run(object);
    }


    @Override
    public List<OrionAnnotation> gatherInstanceVariablesAnnotationsFromObject(Object object)
    {
        return GatherInstanceVariablesAnnotationsFromObjectTask.run(object);
    }


    @Override
    public List<OrionAnnotation> gatherConstructorsAnnotationsFromObject(Object object)
    {
        return GatherConstructorsAnnotationsFromObjectTask.run(object);
    }


    @Override
    public List<OrionAnnotation> gatherMethodsAnnotationsFromObject(Object object)
    {
        return GatherMethodsAnnotationsFromObjectTask.run(object);
    }


    @Override
    public List<OrionAnnotation> gatherAnnotationsFromInstanceElement(AnnotatedElement objectElement)
    {
        return GatherAnnotationsFromInstanceElementTask.run(objectElement);
    }
}
package annotations.services.gathering.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import annotations.OrionAnnotation;
import annotations.services.AnnotationServiceObject;
import annotations.services.gathering.AnnotationsGatheringService;
import annotations.services.gathering.impl.tasks.ExtractAnnotationFromClassLevelTask;
import annotations.services.gathering.impl.tasks.ExtractAnnotationFromConstructorTask;
import annotations.services.gathering.impl.tasks.ExtractAnnotationFromInstanceVariableTask;
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
    public List<OrionAnnotation> gatherAllAnnotationsFromObject(Object orionObject)
    {
        return new GatherAllAnnotationsFromObjectTask().run(orionObject);
    }
    
    
    @Override
    public Annotation extractAnnotationFromClassLevel(Class<?> aClass, Class<?> annotationClassToExtract)
    {
        return new ExtractAnnotationFromClassLevelTask().run(aClass, annotationClassToExtract);
    }


    @SuppressWarnings("rawtypes")
    @Override
    public Annotation extractAnnotationFromInstanceVariable(Field instanceVariable, Class annotationClassToExtract)
    {
        return new ExtractAnnotationFromInstanceVariableTask().run(instanceVariable, annotationClassToExtract);
    }


    @Override
    public Annotation extractAnnotationFromConstructor(Constructor<?> constructor, Class<?> annotationClassToExtract)
    {
        return new ExtractAnnotationFromConstructorTask().run(constructor, annotationClassToExtract);
    }


    @SuppressWarnings("rawtypes")
    @Override
    public Annotation extractAnnotationFromMethod(Method method, Class annotationClassToExtract)
    {
        return new ExtractAnnotationFromMethodTask().run(method, annotationClassToExtract);
    }


    @Override
    public List<OrionAnnotation> gatherClassLevelAnnotationsFromObject(Object orionObject)
    {
        return new GatherClassLevelAnnotationsFromObjectTask().run(orionObject);
    }


    @Override
    public List<OrionAnnotation> gatherInstanceVariablesAnnotationsFromObject(Object orionObject)
    {
        return new GatherInstanceVariablesAnnotationsFromObjectTask().run(orionObject);
    }


    @Override
    public List<OrionAnnotation> gatherConstructorsAnnotationsFromObject(Object orionObject)
    {
        return new GatherConstructorsAnnotationsFromObjectTask().run(orionObject);
    }


    @Override
    public List<OrionAnnotation> gatherMethodsAnnotationsFromObject(Object orionObject)
    {
        return new GatherMethodsAnnotationsFromObjectTask().run(orionObject);
    }


    @Override
    public List<OrionAnnotation> gatherObjectElementAnnotationsFromObject(AccessibleObject objectElement)
    {
        return new GatherObjectElementAnnotationsFromObjectTask().run(objectElement);
    }
}
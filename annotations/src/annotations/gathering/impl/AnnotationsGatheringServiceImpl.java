package annotations.gathering.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import annotations.AnnotationServiceObject;
import annotations.OrionAnnotation;
import annotations.gathering.AnnotationsGatheringService;
import annotations.gathering.impl.tasks.ExtractAnnotationFromClassLevelTask;
import annotations.gathering.impl.tasks.ExtractAnnotationFromConstructorTask;
import annotations.gathering.impl.tasks.ExtractAnnotationFromInstanceVariableTask;
import annotations.gathering.impl.tasks.ExtractAnnotationFromMethodTask;
import annotations.gathering.impl.tasks.GatherAllAnnotationsFromObjectTask;
import annotations.gathering.impl.tasks.GatherClassLevelAnnotationsFromObjectTask;
import annotations.gathering.impl.tasks.GatherConstructorsAnnotationsFromObjectTask;
import annotations.gathering.impl.tasks.GatherInstanceVariablesAnnotationsFromObjectTask;
import annotations.gathering.impl.tasks.GatherMethodsAnnotationsFromObjectTask;
import annotations.gathering.impl.tasks.GatherObjectElementAnnotationsFromObjectTask;

public class AnnotationsGatheringServiceImpl extends AnnotationServiceObject implements AnnotationsGatheringService
{
    @Override
    public List<OrionAnnotation> gatherAllAnnotationsFromObject(Object object)
    {
        return new GatherAllAnnotationsFromObjectTask().run(object);
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
    public List<OrionAnnotation> gatherClassLevelAnnotationsFromObject(Object object)
    {
        return new GatherClassLevelAnnotationsFromObjectTask().run(object);
    }


    @Override
    public List<OrionAnnotation> gatherInstanceVariablesAnnotationsFromObject(Object object)
    {
        return new GatherInstanceVariablesAnnotationsFromObjectTask().run(object);
    }


    @Override
    public List<OrionAnnotation> gatherConstructorsAnnotationsFromObject(Object object)
    {
        return new GatherConstructorsAnnotationsFromObjectTask().run(object);
    }


    @Override
    public List<OrionAnnotation> gatherMethodsAnnotationsFromObject(Object object)
    {
        return new GatherMethodsAnnotationsFromObjectTask().run(object);
    }


    @Override
    public List<OrionAnnotation> gatherObjectElementAnnotationsFromObject(AccessibleObject objectElement)
    {
        return new GatherObjectElementAnnotationsFromObjectTask().run(objectElement);
    }
}
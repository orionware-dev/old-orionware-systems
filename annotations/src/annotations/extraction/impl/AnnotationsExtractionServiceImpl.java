package annotations.extraction.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import annotations.AnnotationServiceObject;
import annotations.extraction.AnnotationsExtractionService;
import annotations.extraction.impl.tasks.ExtractAnnotationFromClassLevelTask;
import annotations.extraction.impl.tasks.ExtractAnnotationFromConstructorTask;
import annotations.extraction.impl.tasks.ExtractAnnotationFromInstanceVariableTask;
import annotations.extraction.impl.tasks.ExtractAnnotationFromMethodTask;
import annotations.extraction.impl.tasks.GetAnnotationNameTask;

public class AnnotationsExtractionServiceImpl extends AnnotationServiceObject implements AnnotationsExtractionService
{
    @Override
    public Annotation extractAnnotationFromClassLevel(Class<?> aClass, Class<?> annotationClassToExtract)
    {
        return ExtractAnnotationFromClassLevelTask.run(aClass, annotationClassToExtract);
    }


    @SuppressWarnings("rawtypes")
    @Override
    public Annotation extractAnnotationFromInstanceVariable(Field instanceVariable, Class annotationClassToExtract)
    {
        return ExtractAnnotationFromInstanceVariableTask.run(instanceVariable, annotationClassToExtract);
    }


    @Override
    public Annotation extractAnnotationFromConstructor(Constructor<?> constructor, Class<?> annotationClassToExtract)
    {
        return ExtractAnnotationFromConstructorTask.run(constructor, annotationClassToExtract);
    }


    @SuppressWarnings("rawtypes")
    @Override
    public Annotation extractAnnotationFromMethod(Method method, Class annotationClassToExtract)
    {
        return ExtractAnnotationFromMethodTask.run(method, annotationClassToExtract);
    }
    
    
    @Override
    public String getAnnotationName(Annotation annotation)
    {
        return GetAnnotationNameTask.run(annotation);
    }
}
package core.annotations.services.processor.tasks;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import core.annotations.AnnotationObject;
import core.annotations.AnnotationTask;

public class GatherAllClassLevelAnnotationsTask extends AnnotationObject implements AnnotationTask
{
    public List<Annotation> run(Object object)
    {
        return Arrays.asList(object.getClass().getAnnotations());
    }
}
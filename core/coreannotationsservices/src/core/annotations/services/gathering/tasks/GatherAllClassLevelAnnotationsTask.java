package core.annotations.services.gathering.tasks;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;

public class GatherAllClassLevelAnnotationsTask extends AnnotationServiceObject implements AnnotationTask
{
    public List<Annotation> run(Object object)
    {
        return Arrays.asList(object.getClass().getAnnotations());
    }
}
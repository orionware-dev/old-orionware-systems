package core.annotations.services.processor.tasks;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import core.OrionSimpleObject;
import core.annotations.AnnotationTask;

public class GatherAllClassLevelAnnotationsTask extends OrionSimpleObject implements AnnotationTask
{
    private List<Annotation> allClassLevelAnnotationsList = new ArrayList<Annotation>();
    
    
    public List<Annotation> run(Object object)
    {
        allClassLevelAnnotationsList.addAll(Arrays.asList(object.getClass().getAnnotations()));
        return allClassLevelAnnotationsList;
    }
}
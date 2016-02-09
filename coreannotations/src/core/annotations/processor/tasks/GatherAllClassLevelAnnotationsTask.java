package core.annotations.processor.tasks;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import core.annotations.OrionAnnotationTask;

public class GatherAllClassLevelAnnotationsTask implements OrionAnnotationTask
{
    private List<Annotation> allClassLevelAnnotationsList = new ArrayList<Annotation>();
    
    
    public List<Annotation> run(Object object)
    {
        allClassLevelAnnotationsList.addAll(Arrays.asList(object.getClass().getAnnotations()));
        return allClassLevelAnnotationsList;
    }
}
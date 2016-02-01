package core.annotations.processor.tasks;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import core.OrionObject;
import core.services.OrionTask;

public class GatherAllClassLevelAnnotationsTask implements OrionTask
{
    private List<Annotation> allClassLevelAnnotationsList = new ArrayList<Annotation>();
    
    
    public List<Annotation> run(OrionObject object)
    {
        allClassLevelAnnotationsList.addAll(Arrays.asList(object.getClass().getAnnotations()));
        return allClassLevelAnnotationsList;
    }
}
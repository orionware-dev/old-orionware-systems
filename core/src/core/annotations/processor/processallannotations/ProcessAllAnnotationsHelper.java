package core.annotations.processor.processallannotations;

import java.lang.annotation.Annotation;
import java.util.List;
import core.OrionObject;
import core.annotations.processor.processallannotations.tasks.ApplyAnnotationsTask;
import core.annotations.processor.processallannotations.tasks.GatherAllObjectAnnotationsTask;
import core.services.OrionServiceHelper;

public class ProcessAllAnnotationsHelper implements OrionServiceHelper
{
    private GatherAllObjectAnnotationsTask gatherAllObjectAnnotationsTask = new GatherAllObjectAnnotationsTask();
    private ApplyAnnotationsTask applyAnnotationsTask = new ApplyAnnotationsTask();
    
    
    public void processAllAnnotations(OrionObject OrionObject)
    {
        List<Annotation> allObjectAnnotationsList = gatherAllObjectAnnotationsTask.run(OrionObject);
        applyAnnotationsTask.run(OrionObject, allObjectAnnotationsList);
    }
}
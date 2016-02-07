package core.annotations.processor.gatherer.tasks;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import core.OrionObject;
import core.services.OrionTask;

public class GatherAllObjectAnnotationsTask implements OrionTask
{
    private List<Annotation> allObjectAnnotationsList = new ArrayList<Annotation>();
    private GatherAllClassLevelAnnotationsTask gatherAllClassLevelAnnotationsTask = new GatherAllClassLevelAnnotationsTask();
    private GatherAllObjectConstructorsAnnotationsTask gatherAllObjectConstructorsAnnotationsTask = new GatherAllObjectConstructorsAnnotationsTask();
    private GatherAllObjectMethodsAnnotationsTask gatherAllObjectMethodsAnnotationsTask = new GatherAllObjectMethodsAnnotationsTask();
    private GatherAllObjectVariablesAnnotationsTask gatherAllObjectVariablesAnnotationsTask = new GatherAllObjectVariablesAnnotationsTask();
    
    
    public List<Annotation> run(OrionObject object)
    {
        allObjectAnnotationsList.addAll(gatherAllClassLevelAnnotationsTask.run(object));
        allObjectAnnotationsList.addAll(gatherAllObjectConstructorsAnnotationsTask.run(object));
        allObjectAnnotationsList.addAll(gatherAllObjectMethodsAnnotationsTask.run(object));
        allObjectAnnotationsList.addAll(gatherAllObjectVariablesAnnotationsTask.run(object));
        return allObjectAnnotationsList;
    }
}
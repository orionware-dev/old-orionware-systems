package core.annotations.processor.tasks;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import core.annotations.OrionAnnotationTask;

public class GatherAllObjectAnnotationsTask implements OrionAnnotationTask
{
    private List<Annotation> allObjectAnnotationsList = new ArrayList<Annotation>();
    private GatherAllClassLevelAnnotationsTask gatherAllClassLevelAnnotationsTask = new GatherAllClassLevelAnnotationsTask();
    private GatherAllObjectConstructorsAnnotationsTask gatherAllObjectConstructorsAnnotationsTask = new GatherAllObjectConstructorsAnnotationsTask();
    private GatherAllObjectMethodsAnnotationsTask gatherAllObjectMethodsAnnotationsTask = new GatherAllObjectMethodsAnnotationsTask();
    private GatherAllObjectVariablesAnnotationsTask gatherAllObjectVariablesAnnotationsTask = new GatherAllObjectVariablesAnnotationsTask();
    
    
    public List<Annotation> run(Object object)
    {
        allObjectAnnotationsList.addAll(gatherAllClassLevelAnnotationsTask.run(object));
        allObjectAnnotationsList.addAll(gatherAllObjectConstructorsAnnotationsTask.run(object));
        allObjectAnnotationsList.addAll(gatherAllObjectMethodsAnnotationsTask.run(object));
        allObjectAnnotationsList.addAll(gatherAllObjectVariablesAnnotationsTask.run(object));
        return allObjectAnnotationsList;
    }
}
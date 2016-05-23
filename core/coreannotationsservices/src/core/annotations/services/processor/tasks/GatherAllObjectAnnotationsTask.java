package core.annotations.services.processor.tasks;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import core.annotations.AnnotationObject;
import core.annotations.AnnotationTask;

public class GatherAllObjectAnnotationsTask extends AnnotationObject implements AnnotationTask
{
    private List<Annotation> allObjectAnnotationsList;
    private GatherAllClassLevelAnnotationsTask gatherAllClassLevelAnnotationsTask;
    private GatherAllObjectConstructorsAnnotationsTask gatherAllObjectConstructorsAnnotationsTask;
    private GatherAllObjectMethodsAnnotationsTask gatherAllObjectMethodsAnnotationsTask;
    private GatherAllObjectVariablesAnnotationsTask gatherAllObjectVariablesAnnotationsTask;
    
    
    public GatherAllObjectAnnotationsTask()
    {
        allObjectAnnotationsList = new ArrayList<Annotation>();
        gatherAllClassLevelAnnotationsTask = new GatherAllClassLevelAnnotationsTask();
        gatherAllObjectConstructorsAnnotationsTask = new GatherAllObjectConstructorsAnnotationsTask();
        gatherAllObjectMethodsAnnotationsTask = new GatherAllObjectMethodsAnnotationsTask();
        gatherAllObjectVariablesAnnotationsTask = new GatherAllObjectVariablesAnnotationsTask();
    }
    
    
    public List<Annotation> run(Object object)
    {
        allObjectAnnotationsList.addAll(gatherAllClassLevelAnnotationsTask.run(object));
        allObjectAnnotationsList.addAll(gatherAllObjectConstructorsAnnotationsTask.run(object));
        allObjectAnnotationsList.addAll(gatherAllObjectMethodsAnnotationsTask.run(object));
        allObjectAnnotationsList.addAll(gatherAllObjectVariablesAnnotationsTask.run(object));
        return allObjectAnnotationsList;
    }
}
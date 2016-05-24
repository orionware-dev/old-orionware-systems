package core.annotations.services.processor.tasks;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;

public class GatherAllObjectAnnotationsTask extends AnnotationServiceObject implements AnnotationTask
{
    private List<Annotation> allObjectAnnotationsList;
    private GatherAllClassLevelAnnotationsTask gatherAllClassLevelAnnotationsTask;
    private GatherAllObjectConstructorsAnnotationsTask gatherAllObjectConstructorsAnnotationsTask;
    private GatherAllObjectMethodsAnnotationsTask gatherAllObjectMethodsAnnotationsTask;
    private GatherAllObjectVariablesAnnotationsTask gatherAllObjectVariablesAnnotationsTask;
    
    
    public GatherAllObjectAnnotationsTask()
    {
        this.allObjectAnnotationsList = new ArrayList<Annotation>();
        this.gatherAllClassLevelAnnotationsTask = new GatherAllClassLevelAnnotationsTask();
        this.gatherAllObjectConstructorsAnnotationsTask = new GatherAllObjectConstructorsAnnotationsTask();
        this.gatherAllObjectMethodsAnnotationsTask = new GatherAllObjectMethodsAnnotationsTask();
        this.gatherAllObjectVariablesAnnotationsTask = new GatherAllObjectVariablesAnnotationsTask();
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
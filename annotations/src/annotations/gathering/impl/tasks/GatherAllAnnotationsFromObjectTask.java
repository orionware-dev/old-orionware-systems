package annotations.gathering.impl.tasks;

import java.util.ArrayList;
import java.util.List;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import annotations.OrionAnnotation;

public class GatherAllAnnotationsFromObjectTask extends AnnotationServiceObject implements AnnotationTask
{
    private GatherClassLevelAnnotationsFromObjectTask gatherClassLevelAnnotationsFromObjectTask;
    private GatherInstanceVariablesAnnotationsFromObjectTask gatherInstanceVariablesAnnotationsFromObjectTask;
    private GatherConstructorsAnnotationsFromObjectTask gatherConstructorsAnnotationsFromObjectTask;
    private GatherMethodsAnnotationsFromObjectTask gatherMethodsAnnotationsFromObjectTask;
    
    
    public GatherAllAnnotationsFromObjectTask()
    {
        this.gatherClassLevelAnnotationsFromObjectTask = new GatherClassLevelAnnotationsFromObjectTask();
        this.gatherInstanceVariablesAnnotationsFromObjectTask = new GatherInstanceVariablesAnnotationsFromObjectTask();
        this.gatherConstructorsAnnotationsFromObjectTask = new GatherConstructorsAnnotationsFromObjectTask();
        this.gatherMethodsAnnotationsFromObjectTask = new GatherMethodsAnnotationsFromObjectTask();
    }


    public synchronized List<OrionAnnotation> run(Object object)
    {
        List<OrionAnnotation> allObjectAnnotations = new ArrayList<OrionAnnotation>();
        allObjectAnnotations.addAll(gatherClassLevelAnnotationsFromObjectTask.run(object));
        allObjectAnnotations.addAll(gatherInstanceVariablesAnnotationsFromObjectTask.run(object));
        allObjectAnnotations.addAll(gatherConstructorsAnnotationsFromObjectTask.run(object));
        allObjectAnnotations.addAll(gatherMethodsAnnotationsFromObjectTask.run(object));
        return allObjectAnnotations;
    }
}
package annotations.services.gathering.impl.tasks;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import annotations.AnnotationTask;
import annotations.AnnotationType;
import annotations.OrionAnnotation;
import annotations.services.AnnotationServiceObject;

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
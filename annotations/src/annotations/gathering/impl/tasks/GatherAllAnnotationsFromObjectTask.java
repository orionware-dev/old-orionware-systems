package annotations.gathering.impl.tasks;

import java.util.ArrayList;
import java.util.List;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import annotations.OrionAnnotation;

public class GatherAllAnnotationsFromObjectTask extends AnnotationServiceObject implements AnnotationTask
{
    public static synchronized List<OrionAnnotation> run(Object object)
    {
        List<OrionAnnotation> allObjectAnnotations = new ArrayList<OrionAnnotation>();
        allObjectAnnotations.addAll(GatherClassLevelAnnotationsFromObjectTask.run(object));
        allObjectAnnotations.addAll(GatherInstanceVariablesAnnotationsFromObjectTask.run(object));
        allObjectAnnotations.addAll(GatherConstructorsAnnotationsFromObjectTask.run(object));
        allObjectAnnotations.addAll(GatherMethodsAnnotationsFromObjectTask.run(object));
        return allObjectAnnotations;
    }
}
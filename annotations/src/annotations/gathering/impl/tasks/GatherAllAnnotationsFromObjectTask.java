package annotations.gathering.impl.tasks;

import java.util.ArrayList;
import java.util.List;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import annotations.OrionAnnotation;

public class GatherAllAnnotationsFromObjectTask extends AnnotationServiceObject implements AnnotationTask
{
    public synchronized List<OrionAnnotation> run(Object object)
    {
        List<OrionAnnotation> allObjectAnnotations = new ArrayList<OrionAnnotation>();
        allObjectAnnotations.addAll(new GatherClassLevelAnnotationsFromObjectTask().run(object));
        allObjectAnnotations.addAll(new GatherInstanceVariablesAnnotationsFromObjectTask().run(object));
        allObjectAnnotations.addAll(new GatherConstructorsAnnotationsFromObjectTask().run(object));
        allObjectAnnotations.addAll(new GatherMethodsAnnotationsFromObjectTask().run(object));
        return allObjectAnnotations;
    }
}
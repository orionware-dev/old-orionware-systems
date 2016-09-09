package annotations.services.filtering.impl.tasks;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;
import annotations.AnnotationTask;
import annotations.OrionAnnotation;
import annotations.services.AnnotationServiceObject;
import annotations.services.registry.AnnotationsRegistry;

public class FilterRegisteredAnnotationsFromObjectAnnotationsTask extends AnnotationServiceObject implements AnnotationTask
{
    public Stream<OrionAnnotation> run(Collection<Annotation> allObjectAnnotations)
    {
        DoesObjectHaveRegisteredAnnotationTask doesObjectHaveRegisteredAnnotationTask = new DoesObjectHaveRegisteredAnnotationTask();
        //takes registered annotations 1-by-1 and it returns the ones that are both registered
        //and in the object annotations (allObjectAnnotationsList). This ensures that Orion
        //only processes the registered annotations which means, the Orion-based annotations
        //and the ones the developer created using the Orion Annotations Engine.
        //The rest of the annotations in allObjectAnnotationsList are Java/Spring/etc. annotations
        //and Orion does not concern itself with those
        return AnnotationsRegistry.filterAnnotations(annotation ->
            doesObjectHaveRegisteredAnnotationTask.run(allObjectAnnotations, (OrionAnnotation)annotation));
    }


    public Stream<OrionAnnotation> run(Annotation[] allObjectAnnotationsArray)
    {
        return run(Arrays.asList(allObjectAnnotationsArray));
    }
}
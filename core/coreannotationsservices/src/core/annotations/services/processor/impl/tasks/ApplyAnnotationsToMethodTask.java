package core.annotations.services.processor.impl.tasks;

import java.util.Collection;
import java.util.stream.Stream;
import core.annotations.AnnotationTask;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;

public class ApplyAnnotationsToMethodTask extends AnnotationServiceObject implements AnnotationTask
{
    public void run(Stream<OrionAnnotation> annotationsStream, Object OrionObject)
    {
        ApplyAnnotationToMethodTask applyAnnotationToMethodTask = new ApplyAnnotationToMethodTask();
        annotationsStream.forEach(annotation -> applyAnnotationToMethodTask.run(OrionObject, (OrionAnnotation)annotation));
    }
    
    
    public void run(Collection<OrionAnnotation> annotationsStream, Object OrionObject)
    {
        run(annotationsStream.stream(), OrionObject);
    }
}
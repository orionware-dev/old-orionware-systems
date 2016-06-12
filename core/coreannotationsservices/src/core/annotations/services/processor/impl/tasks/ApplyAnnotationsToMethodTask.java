package core.annotations.services.processor.impl.tasks;

import java.util.Collection;
import java.util.stream.Stream;
import core.annotations.AnnotationTask;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;

public class ApplyAnnotationsToMethodTask extends AnnotationServiceObject implements AnnotationTask
{
    public static synchronized void run(Stream<OrionAnnotation> annotationsStream, Object OrionObject)
    {
        annotationsStream.forEach(annotation -> ApplyAnnotationToMethodTask.run(OrionObject, (OrionAnnotation)annotation));
    }


    public static synchronized void run(Collection<OrionAnnotation> annotationsStream, Object OrionObject)
    {
        run(annotationsStream.stream(), OrionObject);
    }
}
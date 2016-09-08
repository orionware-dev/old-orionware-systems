package core.annotations.services.processor.impl.tasks;

import java.util.Collection;
import java.util.stream.Stream;
import core.annotations.AnnotationTask;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;

public class ApplyAnnotationsToMethodTask extends AnnotationServiceObject implements AnnotationTask
{
    public void run(Stream<OrionAnnotation> annotations, Object orionObject)
    {
        annotations.forEach(annotation -> new ApplyAnnotationToMethodTask().run(orionObject, (OrionAnnotation)annotation));
    }


    public void run(Collection<OrionAnnotation> annotations, Object orionObject)
    {
        run(annotations.stream(), orionObject);
    }
}
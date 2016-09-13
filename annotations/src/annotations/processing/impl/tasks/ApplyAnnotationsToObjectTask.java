package annotations.processing.impl.tasks;

import java.util.List;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import annotations.OrionAnnotation;

public class ApplyAnnotationsToObjectTask extends AnnotationServiceObject implements AnnotationTask
{
    public void run(List<OrionAnnotation> annotations, Object object)
    {
        annotations.forEach(annotation -> new ApplyAnnotationToObjectTask().run(object, annotation));
    }
}
package core.annotations.services.gathering.impl.tasks;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Stream;
import core.annotations.AnnotationTask;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.registry.AnnotationsRegistry;

public class FilterRegisteredAnnotationsStreamFromObjectAnnotationsTask extends AnnotationServiceObject implements AnnotationTask
{
    private List<Annotation> allObjectAnnotationsList;
    
    
    public Stream<OrionAnnotation> run(List<Annotation> allObjectAnnotationsList)
    {
        this.allObjectAnnotationsList = allObjectAnnotationsList;
        //takes registered annotations 1-by-1 and it returns the ones that are both registered
        //and in the object annotations (allObjectAnnotationsList). This ensures that Orion
        //only processes the registered annotations which means, the Orion-based annotations
        //and the ones the developer created using the Orion Annotations Engine.
        //The rest of the annotations in allObjectAnnotationsList are Java/Spring/etc. annotations
        //and Orion does not concern itself with those
        return AnnotationsRegistry.filterAnnotations(annotation -> doesObjectHaveRegisteredAnnotationTask((OrionAnnotation)annotation));
    }
    
    
    private boolean doesObjectHaveRegisteredAnnotationTask(OrionAnnotation registeredAnnotation)
    {
        return allObjectAnnotationsList.stream()
                    .filter(annotation -> 
                        {
                            String annotationName = annotation.annotationType().getName();
                            return annotationName.equals(registeredAnnotation.getAnnotationClass());
                        }).count() == 1;
    }
}
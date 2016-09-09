package annotations.services.gathering.impl.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import annotations.AnnotationTask;
import annotations.AnnotationType;
import annotations.OrionAnnotation;
import annotations.services.AnnotationServiceObject;
import annotations.services.filtering.AnnotationsFilteringService;
import annotations.services.filtering.impl.AnnotationsFilteringServiceImpl;

public class GatherConstructorsAnnotationsFromObjectTask extends AnnotationServiceObject implements AnnotationTask
{
    public List<OrionAnnotation> run(Object object)
    {
        if(object != null)
        {
            GatherObjectElementAnnotationsFromObjectTask gatherObjectElementAnnotationsFromObjectTask = new GatherObjectElementAnnotationsFromObjectTask();
            Constructor<?>[] constructors = object.getClass().getDeclaredConstructors();
            List<OrionAnnotation> allConstructorAnnotations = new ArrayList<OrionAnnotation>();
            Arrays.stream(constructors).forEach(constructor -> allConstructorAnnotations.addAll(gatherObjectElementAnnotationsFromObjectTask.run(constructor)));
            AnnotationsFilteringService annotationsFilteringService = new AnnotationsFilteringServiceImpl();
            //we filter the annotations, because if it finds a registered
            //annotation that matches
            //one in the list of object annotations then we can process it
            //otherwise it means that Orion
            //will have to try to process non-Orion-based annotations like
            //Java/Spring/etc. annotations
            //in which case it is processed by the respective framework
            List<OrionAnnotation> registeredAnnotations = annotationsFilteringService.filterRegisteredAnnotationsFromObjectAnnotations(allConstructorAnnotations);
            
            for(OrionAnnotation annotation : registeredAnnotations)
            {
                annotationsFilteringService.addAnnotationTypeForObject(annotation, AnnotationType.CONSTRUCTOR);
            }
        }
        
        return new ArrayList<OrionAnnotation>();
    }
}
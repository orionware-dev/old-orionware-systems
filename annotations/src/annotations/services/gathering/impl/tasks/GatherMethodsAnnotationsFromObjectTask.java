package annotations.services.gathering.impl.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import annotations.AnnotationTask;
import annotations.AnnotationType;
import annotations.OrionAnnotation;
import annotations.services.AnnotationServiceObject;
import annotations.services.filtering.AnnotationsFilteringService;
import annotations.services.filtering.impl.AnnotationsFilteringServiceImpl;

public class GatherMethodsAnnotationsFromObjectTask extends AnnotationServiceObject implements AnnotationTask
{
    public List<OrionAnnotation> run(Object object)
    {
        if(object != null)
        {
            GatherObjectElementAnnotationsFromObjectTask gatherObjectElementAnnotationsFromObjectTask = new GatherObjectElementAnnotationsFromObjectTask();
            Method[] methods = object.getClass().getDeclaredMethods();
            List<OrionAnnotation> allMethodAnnotations = new ArrayList<OrionAnnotation>();
            Arrays.stream(methods).forEach(method -> allMethodAnnotations.addAll(gatherObjectElementAnnotationsFromObjectTask.run(method)));
            AnnotationsFilteringService annotationsFilteringService = new AnnotationsFilteringServiceImpl();
            //we filter the annotations, because if it finds a registered
            //annotation that matches
            //one in the list of object annotations then we can process it
            //otherwise it means that Orion
            //will have to try to process non-Orion-based annotations like
            //Java/Spring/etc. annotations
            //in which case it is processed by the respective framework
            List<OrionAnnotation> registeredAnnotations = annotationsFilteringService.filterRegisteredAnnotationsFromObjectAnnotations(allMethodAnnotations);
            
            for(OrionAnnotation annotation : registeredAnnotations)
            {
                annotationsFilteringService.addAnnotationTypeForObject(annotation, AnnotationType.METHOD);
            }
            
            return registeredAnnotations;
        }
        
        return new ArrayList<OrionAnnotation>();
    }
}
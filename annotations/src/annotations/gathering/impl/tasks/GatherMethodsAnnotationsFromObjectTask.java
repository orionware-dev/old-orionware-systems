package annotations.gathering.impl.tasks;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import annotations.AnnotationType;
import annotations.OrionAnnotation;
import annotations.filtering.AnnotationsFilteringService;
import annotations.filtering.impl.AnnotationsFilteringServiceImpl;
import reflection.methods.retrieval.impl.ReflectionMethodsRetrievalServiceImpl;

public class GatherMethodsAnnotationsFromObjectTask extends AnnotationServiceObject implements AnnotationTask
{
    private static AnnotationsFilteringService annotationsFilteringService = new AnnotationsFilteringServiceImpl();
    
    
    public static List<OrionAnnotation> run(Object object)
    {
        if(object != null)
        {
            List<Method> methods = new ReflectionMethodsRetrievalServiceImpl().getDeclaredMethods(object);
            List<OrionAnnotation> allMethodAnnotations = new ArrayList<OrionAnnotation>();
            methods.forEach(method -> allMethodAnnotations.addAll(GatherInstanceElementAnnotationsFromObjectTask.run(method)));
            //we filter the annotations, because if it finds a registered
            //annotation that matches
            //one in the list of object annotations then we can process it
            //otherwise it means that Orion
            //will have to try to process non-Orion-based annotations like
            //Java/Spring/etc. annotations
            //in which case it is processed by the respective framework
            List<OrionAnnotation> registeredAnnotations = annotationsFilteringService.filterRegisteredAnnotationsFromObjectAnnotations(allMethodAnnotations);
            registeredAnnotations.forEach(orionAnnotation -> annotationsFilteringService.addAnnotationTypeForObject(orionAnnotation, AnnotationType.METHOD));
            return registeredAnnotations;
        }
        
        return new ArrayList<OrionAnnotation>();
    }
}
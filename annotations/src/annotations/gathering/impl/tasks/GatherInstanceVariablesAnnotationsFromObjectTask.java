package annotations.gathering.impl.tasks;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import annotations.AnnotationType;
import annotations.OrionAnnotation;
import annotations.filtering.AnnotationsFilteringService;
import annotations.filtering.impl.AnnotationsFilteringServiceImpl;
import reflection.instancevariables.retrieval.impl.ReflectionInstanceVariablesRetrievalServiceImpl;

public class GatherInstanceVariablesAnnotationsFromObjectTask extends AnnotationServiceObject implements AnnotationTask
{
    public List<OrionAnnotation> run(Object object)
    {
        if(object != null)
        {
            GatherInstanceElementAnnotationsFromObjectTask gatherInstanceElementAnnotationsFromObjectTask = new GatherInstanceElementAnnotationsFromObjectTask();
            List<Field> variables = new ReflectionInstanceVariablesRetrievalServiceImpl().getDeclaredInstanceVariables(object);
            List<OrionAnnotation> allInstanceVariablesAnnotations = new ArrayList<OrionAnnotation>();
            variables.forEach(variable -> allInstanceVariablesAnnotations.addAll(gatherInstanceElementAnnotationsFromObjectTask.run(variable)));
            AnnotationsFilteringService annotationsFilteringService = new AnnotationsFilteringServiceImpl();
            //we filter the annotations, because if it finds a registered
            //annotation that matches
            //one in the list of object annotations then we can process it
            //otherwise it means that Orion
            //will have to try to process non-Orion-based annotations like
            //Java/Spring/etc. annotations
            //in which case it is processed by the respective framework
            List<OrionAnnotation> registeredAnnotations = annotationsFilteringService.filterRegisteredAnnotationsFromObjectAnnotations(allInstanceVariablesAnnotations);
            registeredAnnotations.forEach(orionAnnotation -> annotationsFilteringService.addAnnotationTypeForObject(orionAnnotation, AnnotationType.INSTANCE_VARIABLE));
            return registeredAnnotations;
        }
        
        return new ArrayList<OrionAnnotation>();
    }
}
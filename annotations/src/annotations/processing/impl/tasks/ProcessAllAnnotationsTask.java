package annotations.processing.impl.tasks;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import annotations.OrionAnnotation;
import annotations.configuration.ObjectAnnotationsUsed;
import annotations.gathering.impl.AnnotationsGatheringServiceImpl;

public class ProcessAllAnnotationsTask extends AnnotationServiceObject implements AnnotationTask
{
    public static void run(Object object)
    {
        CopyOnWriteArrayList<OrionAnnotation> registeredAnnotationsForObject = null;
        
        //object annotations have been registered
        if(ObjectAnnotationsUsed.OBJECTS_ANNOTATIONS_USED_MAPPER.get(object.getClass()) != null)
        {
            registeredAnnotationsForObject = ObjectAnnotationsUsed.getAnnotationsUsedByObject(object);
        }
        else
        {
            List<OrionAnnotation> registeredAnnotationsForObjectList = new AnnotationsGatheringServiceImpl().gatherAllAnnotationsFromObject(object);
            registeredAnnotationsForObject = new CopyOnWriteArrayList<OrionAnnotation>(registeredAnnotationsForObjectList);
            ObjectAnnotationsUsed.registerObjectAnnotationsUsed(object, registeredAnnotationsForObject);
        }
        
        new ApplyAnnotationsToObjectTask().run(registeredAnnotationsForObject, object);
    }
}
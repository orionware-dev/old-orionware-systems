package annotations.gathering;

import java.lang.reflect.AnnotatedElement;
import java.util.List;
import annotations.AnnotationService;
import annotations.OrionAnnotation;

public interface AnnotationsGatheringService extends AnnotationService
{
    public List<OrionAnnotation> gatherAllAnnotationsFromObject(Object object);
    
    
    public List<OrionAnnotation> gatherClassLevelAnnotationsFromObject(Object object);
    
    
    public List<OrionAnnotation> gatherInstanceVariablesAnnotationsFromObject(Object object);
    
    
    public List<OrionAnnotation> gatherConstructorsAnnotationsFromObject(Object object);
    
    
    public List<OrionAnnotation> gatherMethodsAnnotationsFromObject(Object object);
    
    
    public List<OrionAnnotation> gatherAnnotationsFromInstanceElement(AnnotatedElement objectElement);
}
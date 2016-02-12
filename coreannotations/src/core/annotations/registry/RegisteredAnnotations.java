package core.annotations.registry;

import java.util.HashSet;
import java.util.Set;
import core.annotations.OrionAnnotation;

public class RegisteredAnnotations
{
    public static Set<OrionAnnotation> registeredAnnotationsSet;
    
    
    static
    {
        registeredAnnotationsSet = new HashSet<OrionAnnotation>();
    }
    
    
    public static void add(OrionAnnotation registeredAnnotation)
    {
        registeredAnnotationsSet.add(registeredAnnotation);
    }
}
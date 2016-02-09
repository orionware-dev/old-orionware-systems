package core.annotations.registry;

import java.util.HashSet;
import java.util.Set;
import core.annotations.RegisteredAnnotation;

public class RegisteredAnnotations
{
    public static Set<RegisteredAnnotation> registeredAnnotationsSet;
    
    
    static
    {
        registeredAnnotationsSet = new HashSet<RegisteredAnnotation>();
    }
    
    
    public static void add(RegisteredAnnotation registeredAnnotation)
    {
        registeredAnnotationsSet.add(registeredAnnotation);
    }
}
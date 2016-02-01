package core.registry;

import java.util.HashSet;
import java.util.Set;
import core.annotations.RegisteredAnnotation;
import core.general.OrionConfiguration;

public class RegisteredAnnotations extends OrionConfiguration
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
package core.registry;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import core.configuration.RegisteredAnnotation;
import core.general.OrionConfiguration;

public class RegisteredAnnotations extends OrionConfiguration
{
    private static Set<RegisteredAnnotation> registeredAnnotationsSet;
    
    
    static
    {
        registeredAnnotationsSet = new HashSet<RegisteredAnnotation>();
    }
    
    
    public static Set<RegisteredAnnotation> getAnnotations()
    {
        return registeredAnnotationsSet;
    }
    
    
    public static void add(RegisteredAnnotation registeredAnnotation)
    {
        registeredAnnotationsSet.add(registeredAnnotation);
    }
    
    
    @SuppressWarnings("unchecked")
    public static void forEach(Consumer<?> action)
    {
        registeredAnnotationsSet.forEach((Consumer<? super RegisteredAnnotation>)action);
    }
}
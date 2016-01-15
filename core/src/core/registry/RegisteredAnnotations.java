package core.registry;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import core.annotations.RegisteredAnnotation;
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
        getAnnotations().add(registeredAnnotation);
    }
    
    
    @SuppressWarnings("unchecked")
    public static void forEach(Consumer<?> action)
    {
        getAnnotations().forEach((Consumer<? super RegisteredAnnotation>)action);
    }
}
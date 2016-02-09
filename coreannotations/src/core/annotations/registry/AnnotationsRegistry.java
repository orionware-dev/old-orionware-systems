package core.annotations.registry;

import java.io.InputStream;
import java.util.Set;
import java.util.function.Consumer;
import core.annotations.RegisteredAnnotation;
import core.annotations.registry.RegisteredAnnotations;
import core.configuration.OrionProperties;

public class AnnotationsRegistry
{
    public static void registerAnnotation(RegisteredAnnotation registeredAnnotation)
    {
        RegisteredAnnotations.add(registeredAnnotation);
    }
    
    
    public static Set<RegisteredAnnotation> getAnnotations()
    {
        return RegisteredAnnotations.registeredAnnotationsSet;
    }
    
    
    @SuppressWarnings("unchecked")
    public static void forEachAnnotation(Consumer<?> action)
    {
        getAnnotations().forEach((Consumer<? super RegisteredAnnotation>)action);
    }
}
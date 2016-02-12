package core.annotations.services.registry;

import java.util.Set;
import java.util.function.Consumer;
import core.annotations.OrionAnnotation;

public class AnnotationsRegistry
{
    public static void registerAnnotation(OrionAnnotation registeredAnnotation)
    {
        RegisteredAnnotations.add(registeredAnnotation);
    }
    
    
    public static Set<OrionAnnotation> getAnnotations()
    {
        return RegisteredAnnotations.registeredAnnotationsSet;
    }
    
    
    @SuppressWarnings("unchecked")
    public static void forEachAnnotation(Consumer<?> action)
    {
        getAnnotations().forEach((Consumer<? super OrionAnnotation>)action);
    }
}
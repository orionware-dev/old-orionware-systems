package core.annotations.services.registry;

import java.util.Set;
import java.util.function.Consumer;
import core.OrionSimpleObject;
import core.annotations.OrionAnnotation;
import core.general.OrionRegistry;

public class AnnotationsRegistry extends OrionRegistry
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
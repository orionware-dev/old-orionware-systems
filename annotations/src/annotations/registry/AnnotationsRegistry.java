package annotations.registry;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import annotations.OrionAnnotation;
import core.abstraction.OrionRegistry;

public class AnnotationsRegistry extends OrionRegistry
{
    public static Set<OrionAnnotation> registeredAnnotations;

    static
    {
        registeredAnnotations = new CopyOnWriteArraySet<OrionAnnotation>();
    }


    public static synchronized void registerAnnotation(OrionAnnotation annotationToRegister)
    {
        getAnnotations().add(annotationToRegister);
    }


    public static Set<OrionAnnotation> getAnnotations()
    {
        return registeredAnnotations;
    }


    @SuppressWarnings("unchecked")
    public static Stream<OrionAnnotation> filterAnnotations(Predicate<?> filter)
    {
        return getAnnotations().stream().filter((Predicate<? super OrionAnnotation>)filter);
    }


    @SuppressWarnings("unchecked")
    public static void forEachAnnotation(Consumer<?> action)
    {
        getAnnotations().forEach((Consumer<? super OrionAnnotation>)action);
    }


    public static boolean isAnnotationRegistered(OrionAnnotation annotation)
    {
        boolean isAnnotationRegistered = false;

        for(OrionAnnotation registeredAnnotation : getAnnotations())
        {
            if(registeredAnnotation != null && registeredAnnotation.getAnnotationClass().equals(annotation.getAnnotationClass()) && registeredAnnotation.getAnnotationService().equals(annotation.getAnnotationService()) && registeredAnnotation.getAnnotationServiceMethodToCall().equals(annotation.getAnnotationServiceMethodToCall()))
            {
                return true;
            }
        }

        return isAnnotationRegistered;
    }
}
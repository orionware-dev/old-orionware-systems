package core.annotations.processor.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import core.OrionObject;
import core.annotations.RegisteredAnnotation;
import core.reflection.ReflectionService;
import core.registry.OrionRegistry;
import core.services.OrionTask;

public class ApplyAnnotationsTask implements OrionTask
{
    private ReflectionService reflectionService;
    private OrionObject object;
    private List<Annotation> allObjectAnnotationsList;
    

    public void run(ReflectionService reflectionService, OrionObject object, List<Annotation> allObjectAnnotationsList)
    {
        this.reflectionService = reflectionService;
        this.object = object;
        this.allObjectAnnotationsList = allObjectAnnotationsList;
        OrionRegistry.forEachAnnotation((annotation) -> applyAnnotation((RegisteredAnnotation)annotation));
    }
    
    
    private void applyAnnotation(RegisteredAnnotation registeredAnnotation)
    {
        //if it finds a registered annotation that matches the one it is processing now then process it
        //otherwise it means that we are processing an annotation that has not been registered
        //in which case we ignore it. It could be a Java/Spring/etc. annotation in which
        //case it is processed by the respective framework
        if(thisAnnotationIsRegistered(registeredAnnotation))
        {
            applyAnnotationToMethod(registeredAnnotation);
        }
    }
    
    
    private boolean thisAnnotationIsRegistered(RegisteredAnnotation registeredAnnotation)
    {
        return allObjectAnnotationsList.stream()
                    .filter((annotation) -> annotation.annotationType().getName().equals(registeredAnnotation.getAnnotationClass()))
                    .count() == 1;
    }
    
    
    private void applyAnnotationToMethod(RegisteredAnnotation registeredAnnotation)
    {
        try
        {
            //instantiate annotation service
            Object someAnnotationService = reflectionService.loadAndInstantiateClass(registeredAnnotation.getAnnotationService());
            //call annotation service method that will process this annotation
            Method someMethod = someAnnotationService.getClass().getMethod(registeredAnnotation.getAnnotationServiceMethodToCall(), OrionObject.class);
            reflectionService.callMethod(someMethod, someAnnotationService, object);
        }
        catch(NoSuchMethodException exception)
        {
            exception.printStackTrace();
        }
        catch(SecurityException exception)
        {
            exception.printStackTrace();
        }
        catch(IllegalArgumentException exception)
        {
            exception.printStackTrace();
        }
    }
}
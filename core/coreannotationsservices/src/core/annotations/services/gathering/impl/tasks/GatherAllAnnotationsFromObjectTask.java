package core.annotations.services.gathering.impl.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;

public class GatherAllAnnotationsFromObjectTask extends AnnotationServiceObject implements AnnotationTask
{
    private Object object;
    private List<Annotation> allObjectAnnotations;


    public List<Annotation> run(Object object)
    {
        this.object = object;
        this.allObjectAnnotations = new ArrayList<Annotation>();
        gatherAllClassLevelAnnotations();
        gatherAllObjectConstructorsAnnotations();
        gatherAllObjectMethodsAnnotations();
        gatherAllObjectVariablesAnnotations();
        return allObjectAnnotations;
    }


    private void gatherAllClassLevelAnnotations()
    {
        allObjectAnnotations.addAll(Arrays.asList(object.getClass().getAnnotations()));
    }


    private void getObjectElementAnnotationsAndAppendThemToList(AccessibleObject objectElement)
    {
        Annotation[] annotations = objectElement.getAnnotations();
        allObjectAnnotations.addAll(Arrays.asList(annotations));
    }


    private void gatherAllObjectConstructorsAnnotations()
    {
        Constructor<?>[] constructors = object.getClass().getDeclaredConstructors();
        Stream<Constructor<?>> constructorsStream = Arrays.stream(constructors);
        constructorsStream.forEach(constructor -> getObjectElementAnnotationsAndAppendThemToList(constructor));
    }


    private void gatherAllObjectMethodsAnnotations()
    {
        Method[] methods = object.getClass().getDeclaredMethods();
        Stream<Method> methodsStream = Arrays.stream(methods);
        methodsStream.forEach(method -> getObjectElementAnnotationsAndAppendThemToList(method));
    }


    private void gatherAllObjectVariablesAnnotations()
    {
        Field[] variables = object.getClass().getDeclaredFields();
        Stream<Field> variablesStream = Arrays.stream(variables);
        variablesStream.forEach(method -> getObjectElementAnnotationsAndAppendThemToList(method));
    }
}
package core.annotations.services.gathering.tasks;

import java.lang.annotation.Annotation;
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
    private List<Annotation> allObjectAnnotationsList;
    
    
    public List<Annotation> run(Object object)
    {
        this.object = object;
        allObjectAnnotationsList = new ArrayList<Annotation>();
        gatherAllClassLevelAnnotations();
        gatherAllObjectConstructorsAnnotations();
        gatherAllObjectMethodsAnnotations();
        gatherAllObjectVariablesAnnotations();
        return allObjectAnnotationsList;
    }
    
    
    private void gatherAllClassLevelAnnotations()
    {
        allObjectAnnotationsList.addAll(Arrays.asList(object.getClass().getAnnotations()));
    }
    
    
    private void getConstructorAnnotationsAndAppendThemToList(Constructor<?> constructor)
    {
        Annotation[] annotations = constructor.getAnnotations();
        allObjectAnnotationsList.addAll(Arrays.asList(annotations));
    }
    
    
    private void gatherAllObjectConstructorsAnnotations()
    {
        Constructor<?>[] constructors = object.getClass().getDeclaredConstructors();
        Stream<Constructor<?>> constructorsStream = Arrays.stream(constructors);
        constructorsStream.forEach((constructor) -> getConstructorAnnotationsAndAppendThemToList(constructor));
    }
    
    
    private void getMethodAnnotationsAndAppendThemToList(Method method)
    {
        Annotation[] annotations = method.getAnnotations();
        allObjectAnnotationsList.addAll(Arrays.asList(annotations));
    }
    
    
    private void gatherAllObjectMethodsAnnotations()
    {
        Method[] methods = object.getClass().getDeclaredMethods();
        Stream<Method> methodsStream = Arrays.stream(methods);
        methodsStream.forEach((method) -> getMethodAnnotationsAndAppendThemToList(method));
    }
    
    
    private void getVariableAnnotationsAndAppendThemToList(Field variable)
    {
        Annotation[] annotations = variable.getAnnotations();
        allObjectAnnotationsList.addAll(Arrays.asList(annotations));
    }
    
    
    private void gatherAllObjectVariablesAnnotations()
    {
        Field[] variables = object.getClass().getDeclaredFields();
        Stream<Field> variablesStream = Arrays.stream(variables);
        variablesStream.forEach((method) -> getVariableAnnotationsAndAppendThemToList(method));
    }
}
package core.annotations.services.gathering.tasks.functions;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import core.functions.OrionAbstractFunction;

public class GatherAllObjectVariablesAnnotationsFunction extends OrionAbstractFunction
{
    private List<Annotation> allObjectVariablesAnnotationsList;
    
    
    public GatherAllObjectVariablesAnnotationsFunction()
    {
        this.allObjectVariablesAnnotationsList = new ArrayList<Annotation>();
    }
    
    
    public List<Annotation> run(Object object)
    {
        Field[] variables = object.getClass().getDeclaredFields();
        Stream<Field> variablesStream = Arrays.stream(variables);
        variablesStream.forEach((method) -> getVariableAnnotationsAndAppendThemToList(method));
        return allObjectVariablesAnnotationsList;
    }
    
    
    private void getVariableAnnotationsAndAppendThemToList(Field variable)
    {
        Annotation[] annotations = variable.getAnnotations();
        allObjectVariablesAnnotationsList.addAll(Arrays.asList(annotations));
    }
}
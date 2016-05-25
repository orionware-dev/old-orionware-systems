package core.annotations.services.gathering.tasks.functions;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import core.functions.OrionAbstractFunction;

public class GatherAllObjectVariablesAnnotationsFunction extends OrionAbstractFunction
{
    private List<Annotation> allObjectVariablesAnnotationsList;
    private Object object;
    
    
    public GatherAllObjectVariablesAnnotationsFunction()
    {
        this.allObjectVariablesAnnotationsList = new ArrayList<Annotation>();
    }
    
    
    public List<Annotation> run(Object object)
    {
        this.object = object;
        gatherVariablesAnnotationsAndPutThemInAList();
        return allObjectVariablesAnnotationsList;
    }
    
    
    private void gatherVariablesAnnotationsAndPutThemInAList()
    {
        getStreamForVariables().forEach((method) -> getVariableAnnotationsAndAppendThemToList(method));
    }
    
    
    private Field[] getVariables()
    {
        return object.getClass().getDeclaredFields();
    }
    
    
    private Stream<Field> getStreamForVariables()
    {
        return Arrays.stream(getVariables());
    }
    
    
    private Annotation[] getVariableAnnotations(Field variable)
    {
        return variable.getAnnotations();
    }
    
    
    private void appendVariableAnnotationsToList(Annotation[] annotations)
    {
        allObjectVariablesAnnotationsList.addAll(Arrays.asList(annotations));
    }
    
    
    private void getVariableAnnotationsAndAppendThemToList(Field field)
    {
        appendVariableAnnotationsToList(getVariableAnnotations(field));
    }
}
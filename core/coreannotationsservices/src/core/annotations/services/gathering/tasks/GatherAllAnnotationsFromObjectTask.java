package core.annotations.services.gathering.tasks;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.gathering.tasks.functions.GatherAllClassLevelAnnotationsFunction;
import core.annotations.services.gathering.tasks.functions.GatherAllObjectConstructorsAnnotationsFunction;
import core.annotations.services.gathering.tasks.functions.GatherAllObjectMethodsAnnotationsFunction;
import core.annotations.services.gathering.tasks.functions.GatherAllObjectVariablesAnnotationsFunction;

public class GatherAllAnnotationsFromObjectTask extends AnnotationServiceObject implements AnnotationTask
{
    private List<Annotation> allObjectAnnotationsList;
    private GatherAllClassLevelAnnotationsFunction gatherAllClassLevelAnnotationsFunction;
    private GatherAllObjectConstructorsAnnotationsFunction gatherAllObjectConstructorsAnnotationsFunction;
    private GatherAllObjectMethodsAnnotationsFunction gatherAllObjectMethodsAnnotationsFunction;
    private GatherAllObjectVariablesAnnotationsFunction gatherAllObjectVariablesAnnotationsFunction;
    
    
    public GatherAllAnnotationsFromObjectTask()
    {
        this.allObjectAnnotationsList = new ArrayList<Annotation>();
        this.gatherAllClassLevelAnnotationsFunction = new GatherAllClassLevelAnnotationsFunction();
        this.gatherAllObjectConstructorsAnnotationsFunction = new GatherAllObjectConstructorsAnnotationsFunction();
        this.gatherAllObjectMethodsAnnotationsFunction = new GatherAllObjectMethodsAnnotationsFunction();
        this.gatherAllObjectVariablesAnnotationsFunction = new GatherAllObjectVariablesAnnotationsFunction();
    }
    
    
    public List<Annotation> run(Object object)
    {
        allObjectAnnotationsList.addAll(gatherAllClassLevelAnnotationsFunction.run(object));
        allObjectAnnotationsList.addAll(gatherAllObjectConstructorsAnnotationsFunction.run(object));
        allObjectAnnotationsList.addAll(gatherAllObjectMethodsAnnotationsFunction.run(object));
        allObjectAnnotationsList.addAll(gatherAllObjectVariablesAnnotationsFunction.run(object));
        return allObjectAnnotationsList;
    }
}
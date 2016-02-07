package core.annotations.processor.gatherer.tasks;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import core.OrionObject;
import core.services.OrionTask;

public class GatherAllObjectAnnotationsTask implements OrionTask
{
    private List<Annotation> allObjectAnnotationsList = new ArrayList<Annotation>();
    
    
    public List<Annotation> run(OrionObject object)
    {
        allObjectAnnotationsList.addAll(new GatherAllClassLevelAnnotationsTask().run(object));
        allObjectAnnotationsList.addAll(new GatherAllObjectConstructorsAnnotationsTask().run(object));
        allObjectAnnotationsList.addAll(new GatherAllObjectMethodsAnnotationsTask().run(object));
        allObjectAnnotationsList.addAll(new GatherAllObjectVariablesAnnotationsTask().run(object));
        return allObjectAnnotationsList;
    }
}
package core.annotations.processor.gatherer;

import java.lang.annotation.Annotation;
import java.util.List;
import core.OrionObject;
import core.annotations.processor.gatherer.tasks.GatherAllObjectAnnotationsTask;
import core.services.OrionServiceHelper;

public class GatherAllAnnotationsHelper implements OrionServiceHelper
{
    private GatherAllObjectAnnotationsTask gatherAllObjectAnnotationsTask = new GatherAllObjectAnnotationsTask();
    
    
    public List<Annotation> run(OrionObject OrionObject)
    {
        return gatherAllObjectAnnotationsTask.run(OrionObject);
    }
}
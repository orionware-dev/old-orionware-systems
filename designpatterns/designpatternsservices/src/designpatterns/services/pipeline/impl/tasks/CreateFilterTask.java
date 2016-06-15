package designpatterns.services.pipeline.impl.tasks;

import core.dependencyinjection.Injector;
import designpatterns.DesignPatternsTask;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.filter.Filter;
import designpatterns.services.DesignPatternsServicesObject;

public class CreateFilterTask extends DesignPatternsServicesObject implements DesignPatternsTask
{
    private IsCustomFunctionTask isCustomFunctionTask;
    
    
    public CreateFilterTask()
    {
        
    }
    
    
    public AbstractFilter run(Object function, String methodToRun, Object... functionParameters)
    {
        AbstractFilter filter = new Filter(function, methodToRun, functionParameters);
        return isCustomFunctionTask.run(filter);
    }


    @Injector(ID = "designpatterns.services.pipeline.impl.tasks.IsCustomFunctionTask")
    private void setIsCustomFunctionTask(IsCustomFunctionTask isCustomFunctionTask)
    {
        this.isCustomFunctionTask = isCustomFunctionTask;
    }
}
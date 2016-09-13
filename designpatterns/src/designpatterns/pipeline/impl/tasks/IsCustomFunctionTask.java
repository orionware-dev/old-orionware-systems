package designpatterns.pipeline.impl.tasks;

import java.util.List;
import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import designpatterns.configuration.DesignPatternsInternalConfiguration;
import designpatterns.pipeline.AbstractFilter;

public class IsCustomFunctionTask extends DesignPatternsObject implements DesignPatternsTask
{
    public IsCustomFunctionTask()
    {
        
    }
    
    
    public AbstractFilter run(AbstractFilter filter)
    {
        List<String> allowedClasses = DesignPatternsInternalConfiguration.getPipelineConfiguration()
                                          .getAllowedClassesNames();
        boolean defaultFunctionClassFound = true;
        
        if(allowedClasses != null)
        {            
            for(String allowedClassName : allowedClasses)
            {
                if(filter.getFunction() != null && filter.getFunction().getClass().getName().indexOf(allowedClassName) == -1)
                {
                    filter.setCustomFunction(true);
                    defaultFunctionClassFound = false;
                }
            }
        }
        
        if(defaultFunctionClassFound)
        {
            filter.setCustomFunction(false);
        }
        
        return filter;
    }
}
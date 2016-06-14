package designpatterns.services.pipeline.impl.tasks;

import java.util.List;
import designpatterns.DesignPatternsConfiguration;
import designpatterns.DesignPatternsTask;
import designpatterns.configuration.DesignPatternsInternalConfiguration;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.services.DesignPatternsServicesObject;

public class IsCustomFunctionTask extends DesignPatternsServicesObject implements DesignPatternsTask
{
    public AbstractFilter run(AbstractFilter filter)
    {
        List<String> allowedClasses = DesignPatternsInternalConfiguration.getPipelineConfiguration().getAllowedClassesNames();
        boolean defaultFunctionClassFound = true;
        
        if(allowedClasses != null)
        {            
            for(String allowedClassName : allowedClasses)
            {
                if(filter.getFunction().getClass().getName().indexOf(allowedClassName) == -1)
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
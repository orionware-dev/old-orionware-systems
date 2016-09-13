package designpatterns.pipeline.impl.tasks;

import datastructures.lists.OrionList;
import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import designpatterns.configuration.DesignPatternsInternalConfiguration;
import designpatterns.pipeline.AbstractFilter;

public class SetIsCustomFunctionTask extends DesignPatternsObject implements DesignPatternsTask
{
    public AbstractFilter run(AbstractFilter filter)
    {
        OrionList<String> allowedClassesNames = DesignPatternsInternalConfiguration.getPipelineConfiguration().getAllowedClassesNames();
        boolean defaultFunctionClassFound = true;

        for(String allowedClassName : allowedClassesNames)
        {
            if(filter.getFunction() != null && filter.getFunction().getClass().getName().indexOf(allowedClassName) == -1)
            {
                filter.setCustomFunction(true);
                defaultFunctionClassFound = false;
            }
        }

        if(defaultFunctionClassFound)
        {
            filter.setCustomFunction(false);
        }

        return filter;
    }
}
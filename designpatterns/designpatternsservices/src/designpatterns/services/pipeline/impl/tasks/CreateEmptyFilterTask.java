package designpatterns.services.pipeline.impl.tasks;

import designpatterns.DesignPatternsTask;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.filter.Filter;
import designpatterns.services.DesignPatternsServicesObject;

public class CreateEmptyFilterTask extends DesignPatternsServicesObject implements DesignPatternsTask
{
    public CreateEmptyFilterTask()
    {
        
    }
    
    
    public AbstractFilter run()
    {
        return new Filter();
    }
}
package designpatterns.services.pipeline.impl.tasks;

import designpatterns.DesignPatternsTask;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.filter.Filter;
import designpatterns.DesignPatternsObject;

public class CreateEmptyFilterTask extends DesignPatternsObject implements DesignPatternsTask
{
    public CreateEmptyFilterTask()
    {
        
    }
    
    
    public AbstractFilter run()
    {
        return new Filter();
    }
}
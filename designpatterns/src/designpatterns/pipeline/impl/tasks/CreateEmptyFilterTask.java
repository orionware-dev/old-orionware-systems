package designpatterns.pipeline.impl.tasks;

import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.filter.Filter;

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
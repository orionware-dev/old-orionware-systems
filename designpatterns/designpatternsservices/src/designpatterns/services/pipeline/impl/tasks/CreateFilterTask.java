package designpatterns.services.pipeline.impl.tasks;

import designpatterns.DesignPatternsTask;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.impl.Filter;
import designpatterns.services.DesignPatternsServicesObject;

public class CreateFilterTask extends DesignPatternsServicesObject implements DesignPatternsTask
{
    public AbstractFilter run()
    {
        return new Filter();
    }
}
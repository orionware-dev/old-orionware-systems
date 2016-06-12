package designpatterns.services.pipeline.impl.tasks;

import designpatterns.DesignPatternsTask;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.filter.FunctionalFilter;
import designpatterns.pipeline.filter.ProceduralFilter;
import designpatterns.services.DesignPatternsServicesObject;

public class CreateEmptyFunctionalFilterTask extends DesignPatternsServicesObject implements DesignPatternsTask
{
    public AbstractFilter run()
    {
        return new FunctionalFilter();
    }
}
package designpatterns.services.pipeline.impl.tasks;

import designpatterns.DesignPatternsTask;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.filter.ProceduralFilter;
import designpatterns.services.DesignPatternsServicesObject;

public class CreateEmptyProceduralFilterTask extends DesignPatternsServicesObject implements DesignPatternsTask
{
    public AbstractFilter run()
    {
        return new ProceduralFilter();
    }
}
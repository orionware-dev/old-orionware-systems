package designpatterns.services.pipeline.impl.tasks;

import designpatterns.DesignPatternsTask;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.filter.ProceduralFilter;
import designpatterns.services.DesignPatternsServicesObject;

public class CreateProceduralFilterTask extends DesignPatternsServicesObject implements DesignPatternsTask
{
    public AbstractFilter run(Object function, String methodToRun, Object... functionParameters)
    {
        return new ProceduralFilter(function, methodToRun, functionParameters);
    }
}
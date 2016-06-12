package designpatterns.services.pipeline.impl.tasks;

import designpatterns.DesignPatternsTask;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.impl.Filter;
import designpatterns.services.DesignPatternsServicesObject;

public class CreateFilterTask extends DesignPatternsServicesObject implements DesignPatternsTask
{
    public AbstractFilter run(boolean isFunctionAProcedure, Object function, String methodToRun, Object... functionParameters)
    {
        return new Filter(isFunctionAProcedure, function, methodToRun, functionParameters);
    }
}
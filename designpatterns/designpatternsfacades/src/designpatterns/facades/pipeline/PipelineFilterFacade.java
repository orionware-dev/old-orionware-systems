package designpatterns.facades.pipeline;

import designpatterns.DesignPatternsFacade;
import designpatterns.pipeline.AbstractFilter;

public interface PipelineFilterFacade extends DesignPatternsFacade
{
    public AbstractFilter createEmptyFilter();


    public AbstractFilter createFilter(Object function, String methodToRun, Object... functionParameters);


    public Object executeFilter(AbstractFilter filter, Object functionInput);
}
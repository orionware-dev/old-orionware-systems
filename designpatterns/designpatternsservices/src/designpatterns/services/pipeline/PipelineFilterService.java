package designpatterns.services.pipeline;

import designpatterns.DesignPatternsService;
import designpatterns.pipeline.AbstractFilter;

public interface PipelineFilterService extends DesignPatternsService
{
    public AbstractFilter createEmptyFilter();


    public AbstractFilter createFilter(Object function, String methodToRun, Object... functionParameters);
    
    
    public AbstractFilter isCustomFunction(AbstractFilter filter);


    public Object executeFilter(AbstractFilter filter, Object functionInput);
}
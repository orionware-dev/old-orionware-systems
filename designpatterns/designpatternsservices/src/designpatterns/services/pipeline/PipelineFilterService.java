package designpatterns.services.pipeline;

import designpatterns.DesignPatternsService;
import designpatterns.pipeline.AbstractFilter;

public interface PipelineFilterService extends DesignPatternsService
{
    public AbstractFilter createFilter();
    
    
    public AbstractFilter createFilter(boolean isFunctionAProcedure, Object function, String methodToRun, Object... functionParameters);
    
    
    public Object executeFilter(AbstractFilter filter);
}
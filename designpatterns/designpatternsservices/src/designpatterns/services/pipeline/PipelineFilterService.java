package designpatterns.services.pipeline;

import designpatterns.DesignPatternsService;
import designpatterns.pipeline.AbstractFilter;

public interface PipelineFilterService extends DesignPatternsService
{
    public AbstractFilter createProceduralFilter();
    
    
    public AbstractFilter createProceduralFilter(Object function, String methodToRun, Object... functionParameters);
    
    
    public Object executeFilter(AbstractFilter filter);
}
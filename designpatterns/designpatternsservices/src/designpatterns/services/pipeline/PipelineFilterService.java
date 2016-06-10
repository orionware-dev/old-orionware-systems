package designpatterns.services.pipeline;

import designpatterns.DesignPatternsService;
import designpatterns.pipeline.AbstractFilter;

public interface PipelineFilterService extends DesignPatternsService
{
    public abstract AbstractFilter createFilter();
}
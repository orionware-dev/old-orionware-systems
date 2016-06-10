package designpatterns.services.pipeline.impl;

import designpatterns.DesignPatternsObject;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.pipeline.impl.Pipeline;
import designpatterns.services.DesignPatternsServicesObject;
import designpatterns.services.pipeline.PipelineFilterService;
import designpatterns.services.pipeline.PipelineService;

public class PipelineFilterServiceImpl extends DesignPatternsServicesObject implements PipelineFilterService
{
    @Override
    public AbstractFilter createFilter()
    {
        //new FileSystemStreamsFacadeImpl().getFileStream(libraryAnnotationsDefinitionFilePath);
        return null;
    }
}
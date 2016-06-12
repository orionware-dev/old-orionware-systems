package designpatterns.services.pipeline.impl;

import designpatterns.pipeline.AbstractFilter;
import designpatterns.services.DesignPatternsServicesObject;
import designpatterns.services.pipeline.PipelineFilterService;
import designpatterns.services.pipeline.impl.tasks.CreateEmptyFilterTask;
import designpatterns.services.pipeline.impl.tasks.CreateFilterTask;
import designpatterns.services.pipeline.impl.tasks.ExecuteFilterTask;

public class PipelineFilterServiceImpl extends DesignPatternsServicesObject implements PipelineFilterService
{
    @Override
    public AbstractFilter createEmptyFilter()
    {
        // new
        // FileSystemStreamsFacadeImpl().getFileStream(libraryAnnotationsDefinitionFilePath);
        return new CreateEmptyFilterTask().run();
    }


    @Override
    public AbstractFilter createFilter(Object function, String methodToRun, Object... functionParameters)
    {
        // new
        // FileSystemStreamsFacadeImpl().getFileStream(libraryAnnotationsDefinitionFilePath);
        return new CreateFilterTask().run(function, methodToRun, functionParameters);
    }


    @Override
    public Object executeFilter(AbstractFilter filter)
    {
        return new ExecuteFilterTask().run(filter);
    }
}
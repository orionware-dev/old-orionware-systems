package designpatterns.services.pipeline.impl;

import designpatterns.pipeline.AbstractFilter;
import designpatterns.services.DesignPatternsServicesObject;
import designpatterns.services.pipeline.PipelineFilterService;
import designpatterns.services.pipeline.impl.tasks.CreateEmptyProceduralFilterTask;
import designpatterns.services.pipeline.impl.tasks.CreateProceduralFilterTask;
import designpatterns.services.pipeline.impl.tasks.ExecuteFilterTask;

public class PipelineFilterServiceImpl extends DesignPatternsServicesObject implements PipelineFilterService
{
    @Override
    public AbstractFilter createProceduralFilter()
    {
        //new FileSystemStreamsFacadeImpl().getFileStream(libraryAnnotationsDefinitionFilePath);
        return new CreateEmptyProceduralFilterTask().run();
    }
    
    
    @Override
    public AbstractFilter createProceduralFilter(Object function, String methodToRun, Object... functionParameters)
    {
        return new CreateProceduralFilterTask().run(function, methodToRun, functionParameters);
    }

    
    @Override
    public Object executeFilter(AbstractFilter filter)
    {
        return new ExecuteFilterTask().run(filter);
    }
}
package designpatterns.services.pipeline.impl;

import designpatterns.pipeline.AbstractFilter;
import designpatterns.services.DesignPatternsServicesObject;
import designpatterns.services.pipeline.PipelineFilterService;
import designpatterns.services.pipeline.impl.tasks.CreateEmptyFilterTask;
import designpatterns.services.pipeline.impl.tasks.CreateFilterTask;

public class PipelineFilterServiceImpl extends DesignPatternsServicesObject implements PipelineFilterService
{
    @Override
    public AbstractFilter createFilter()
    {
        //new FileSystemStreamsFacadeImpl().getFileStream(libraryAnnotationsDefinitionFilePath);
        return new CreateEmptyFilterTask().run();
    }
    
    
    @Override
    public AbstractFilter createFilter(boolean isFunctionAProcedure, Object function, String methodToRun, Object... functionParameters)
    {
        return new CreateFilterTask().run(isFunctionAProcedure, function, methodToRun, functionParameters);
    }

    
    @Override
    public Object executeFilter(AbstractFilter filter)
    {
        filter.run();
        return filter.getFunctionResult();
    }
}
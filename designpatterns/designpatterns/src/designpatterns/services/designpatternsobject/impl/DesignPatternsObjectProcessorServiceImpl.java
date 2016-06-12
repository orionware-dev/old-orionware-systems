package designpatterns.services.designpatternsobject.impl;

import java.io.InputStream;
import core.OrionSimpleObject;
import core.filesystem.facades.streams.impl.FileSystemStreamsFacadeImpl;
import designpatterns.configuration.DesignPatternsInternalConfigurationEnumeration;
import designpatterns.services.designpatternsobject.DesignPatternsObjectProcessorService;
import designpatterns.services.designpatternsobject.impl.tasks.RegisterPipelineConfigurationTask;

public class DesignPatternsObjectProcessorServiceImpl extends OrionSimpleObject implements DesignPatternsObjectProcessorService
{
    @Override
    public boolean registerDesignPatternsConfiguration()
    {
        boolean hasPipelineConfigurationBeenRegistered = registerPipelineConfiguration();

        return hasPipelineConfigurationBeenRegistered;
    }


    @Override
    public boolean registerPipelineConfiguration()
    {
        InputStream input = new FileSystemStreamsFacadeImpl().getFileStream(DesignPatternsInternalConfigurationEnumeration.PIPELINE_CONFIGURATION_FILE_PATH.get());
        return new RegisterPipelineConfigurationTask().run(input);
    }
}
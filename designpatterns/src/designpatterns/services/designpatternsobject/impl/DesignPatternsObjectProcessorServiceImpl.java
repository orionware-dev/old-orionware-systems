package designpatterns.services.designpatternsobject.impl;

import java.io.InputStream;
import core.OrionSimpleObject;
import designpatterns.configuration.DesignPatternsInternalConfigurationEnumeration;
import designpatterns.services.designpatternsobject.DesignPatternsObjectProcessorService;
import designpatterns.services.designpatternsobject.impl.tasks.RegisterPipelineConfigurationTask;
import filesystem.services.streams.impl.FileSystemStreamsServiceImpl;

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
        InputStream input = new FileSystemStreamsServiceImpl().getFileStream(DesignPatternsInternalConfigurationEnumeration.PIPELINE_CONFIGURATION_FILE_PATH.get());
        return new RegisterPipelineConfigurationTask().run(input);
    }
}
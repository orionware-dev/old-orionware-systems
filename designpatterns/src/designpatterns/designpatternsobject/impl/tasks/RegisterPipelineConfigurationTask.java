package designpatterns.designpatternsobject.impl.tasks;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import configuration.OrionProperties;
import configuration.registry.ConfigurationRegistry;
import core.OrionSimpleObject;
import designpatterns.DesignPatternsTask;
import designpatterns.configuration.DesignPatternsInternalConfiguration;
import designpatterns.configuration.DesignPatternsLibraryConfiguration;
import designpatterns.configuration.PipelineConfiguration;
import filesystem.streams.impl.FileSystemStreamsServiceImpl;

public class RegisterPipelineConfigurationTask extends OrionSimpleObject implements DesignPatternsTask
{
    public boolean run(InputStream pipelineConfigurationInput)
    {
        OrionProperties pipelineProperties = new OrionProperties();
        pipelineProperties.loadProperties(pipelineConfigurationInput);
        ConfigurationRegistry.loadProperties(pipelineProperties);
        List<String> allowedClassesNames = new ArrayList<String>();
        int index = 1;
        String defaultAllowedClass = (String)pipelineProperties.get("design.patterns.pipeline.filter.default.allowed.class." + index);

        while(defaultAllowedClass != null)
        {
            allowedClassesNames.add(defaultAllowedClass);
            ++index;
            defaultAllowedClass = (String)pipelineProperties.get("design.patterns.pipeline.filter.default.allowed.class." + index);
        }

        PipelineConfiguration pipelineConfiguration = new PipelineConfiguration();
        pipelineConfiguration.setAllowedClassesNames(allowedClassesNames);
        DesignPatternsLibraryConfiguration designPatternsLibraryConfiguration = new DesignPatternsLibraryConfiguration();
        designPatternsLibraryConfiguration.setPipelineConfiguration(pipelineConfiguration);
        DesignPatternsInternalConfiguration.registerDesignPatternsConfiguration(designPatternsLibraryConfiguration);
        DesignPatternsInternalConfiguration.setPipelineConfiguration(pipelineConfiguration);
        new FileSystemStreamsServiceImpl().closeResource(pipelineConfigurationInput);
        return true;
    }
}
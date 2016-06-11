package designpatterns.services.designpatternsobject.impl.tasks;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import core.OrionSimpleObject;
import core.configuration.OrionProperties;
import core.filesystem.facades.streams.impl.FileSystemStreamsFacadeImpl;
import designpatterns.DesignPatternsTask;
import designpatterns.configuration.DesignPatternsConfiguration;
import designpatterns.configuration.DesignPatternsLibraryConfiguration;
import designpatterns.configuration.PipelineConfiguration;

public class RegisterPipelineConfigurationTask extends OrionSimpleObject implements DesignPatternsTask
{
    public boolean run(InputStream pipelineConfigurationInput)
    {
        OrionProperties pipelineProperties = new OrionProperties();
        pipelineProperties.loadProperties(pipelineConfigurationInput);
        Map<Class<?>, String> allowedClassesAndMethods = new HashMap<Class<?>, String>();
        int index = 1;
        
        while(pipelineProperties.get("design.patterns.pipeline.filter.allowed.class." + index) != null)
        {
            Class<?> allowedClass = null;
            
            try
            {
                allowedClass = Class.forName((String)pipelineProperties.get("design.patterns.pipeline.filter.allowed.class." + index));
            }
            catch(ClassNotFoundException exception)
            {
                exception.printStackTrace();
            }
            
            String allowedClassMethod = (String)pipelineProperties.get("design.patterns.pipeline.filter.method.name.for.allowed.class." + index);
            allowedClassesAndMethods.put(allowedClass, allowedClassMethod);
            ++index;
        }
        
        PipelineConfiguration pipelineConfiguration = new PipelineConfiguration();
        pipelineConfiguration.setAllowedClassesAndMethodsMapper(allowedClassesAndMethods);
        DesignPatternsLibraryConfiguration designPatternsLibraryConfiguration = new DesignPatternsLibraryConfiguration();
        designPatternsLibraryConfiguration.setPipelineConfiguration(pipelineConfiguration);
        DesignPatternsConfiguration.registerDesignPatternsConfiguration(designPatternsLibraryConfiguration);
        new FileSystemStreamsFacadeImpl().closeResource(pipelineConfigurationInput);
        return true;
    }
}
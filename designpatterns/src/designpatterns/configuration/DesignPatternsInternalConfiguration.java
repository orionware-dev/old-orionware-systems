package designpatterns.configuration;

import datastructures.sets.factory.impl.SetFactoryServiceImpl;
import datastructures.sets.impl.OrionConcurrentSet;
import designpatterns.DesignPatternsConfiguration;

public class DesignPatternsInternalConfiguration implements DesignPatternsConfiguration
{
    public static boolean haveDesignPatternsConfigurationNotBeenRegistered;
    private static OrionConcurrentSet<DesignPatternsLibraryConfiguration> designPatternsConfiguration;
    private static PipelineConfiguration pipelineConfiguration;

    static
    {
        haveDesignPatternsConfigurationNotBeenRegistered = true;
        designPatternsConfiguration = new SetFactoryServiceImpl<DesignPatternsLibraryConfiguration>().createEmptyConcurrentHashSet();
    }


    public static OrionConcurrentSet<DesignPatternsLibraryConfiguration> getDesignPatternsConfiguration()
    {
        return designPatternsConfiguration;
    }


    public static synchronized void registerDesignPatternsConfiguration(DesignPatternsLibraryConfiguration designPatternsLibraryConfiguration)
    {
        if(haveDesignPatternsConfigurationNotBeenRegistered)
        {
            getDesignPatternsConfiguration().add(designPatternsLibraryConfiguration);

            if(getDesignPatternsConfiguration().contains(designPatternsLibraryConfiguration))
            {
                haveDesignPatternsConfigurationNotBeenRegistered = false;
            }
        }
        else if(!getDesignPatternsConfiguration().contains(designPatternsLibraryConfiguration))
        {
            getDesignPatternsConfiguration().add(designPatternsLibraryConfiguration);
        }
    }


    public static PipelineConfiguration getPipelineConfiguration()
    {
        return pipelineConfiguration;
    }


    public static void setPipelineConfiguration(PipelineConfiguration newPipelineConfiguration)
    {
        pipelineConfiguration = newPipelineConfiguration;
    }
}
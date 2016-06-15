package designpatterns.configuration;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import datastructures.facades.sets.factory.SetFactoryFacade;
import datastructures.facades.sets.factory.impl.SetFactoryFacadeImpl;
import datastructures.sets.OrionConcurrentSet;
import datastructures.sets.OrionSet;
import designpatterns.DesignPatternsConfiguration;

public class DesignPatternsInternalConfiguration extends DesignPatternsConfiguration
{
    public static boolean haveDesignPatternsConfigurationNotBeenRegistered;
    private static OrionConcurrentSet<DesignPatternsLibraryConfiguration> designPatternsConfigurationSet;
    private static PipelineConfiguration pipelineConfiguration;

    
    static
    {
        haveDesignPatternsConfigurationNotBeenRegistered = true;
        SetFactoryFacade<DesignPatternsLibraryConfiguration> setFactoryFacade = new SetFactoryFacadeImpl<DesignPatternsLibraryConfiguration>();
        designPatternsConfigurationSet = setFactoryFacade.createEmptyConcurrentHashSet();
    }


    public static Set<DesignPatternsLibraryConfiguration> getDesignPatternsConfigurationSet()
    {
        return designPatternsConfigurationSet;
    }


    public static synchronized void registerDesignPatternsConfiguration(DesignPatternsLibraryConfiguration designPatternsLibraryConfiguration)
    {
        if(haveDesignPatternsConfigurationNotBeenRegistered)
        {
            getDesignPatternsConfigurationSet().add(designPatternsLibraryConfiguration);

            if(designPatternsConfigurationSet.contains(designPatternsLibraryConfiguration))
            {
                haveDesignPatternsConfigurationNotBeenRegistered = false;
            }
        }
        else if(!designPatternsConfigurationSet.contains(designPatternsLibraryConfiguration))
        {
            getDesignPatternsConfigurationSet().add(designPatternsLibraryConfiguration);
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
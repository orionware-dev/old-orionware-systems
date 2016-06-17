package designpatterns.configuration;

import java.util.Set;
import datastructures.facades.sets.factory.SetFactoryFacade;
import datastructures.facades.sets.factory.impl.SetFactoryFacadeImpl;
import datastructures.sets.impl.OrionConcurrentSet;
import designpatterns.DesignPatternsConfiguration;

public class DesignPatternsInternalConfiguration implements DesignPatternsConfiguration
{
    public static boolean haveDesignPatternsConfigurationNotBeenRegistered;
    private static OrionConcurrentSet<DesignPatternsLibraryConfiguration> designPatternsConfiguration;
    private static PipelineConfiguration pipelineConfiguration;
    private SetFactoryFacade<DesignPatternsLibraryConfiguration> setFactoryFacade;
    
    
    public DesignPatternsInternalConfiguration()
    {
        setFactoryFacade = new SetFactoryFacadeImpl<DesignPatternsLibraryConfiguration>();
    }

    
    static
    {
        haveDesignPatternsConfigurationNotBeenRegistered = true;
        DesignPatternsInternalConfiguration temp = new DesignPatternsInternalConfiguration();
        designPatternsConfiguration = temp.getSetFactoryFacade().createEmptyConcurrentHashSet();
    }


    public static Set<DesignPatternsLibraryConfiguration> getDesignPatternsConfiguration()
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


    public SetFactoryFacade<DesignPatternsLibraryConfiguration> getSetFactoryFacade()
    {
        return this.setFactoryFacade;
    }


    public void setSetFactoryFacade(SetFactoryFacade<DesignPatternsLibraryConfiguration> setFactoryFacade)
    {
        this.setFactoryFacade = setFactoryFacade;
    }
}
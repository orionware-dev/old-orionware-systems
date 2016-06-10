package designpatterns.configuration;

import java.util.HashSet;
import java.util.Set;
import core.abstraction.OrionConfiguration;
import core.configuration.CoreConfigurationEnumeration;
import core.configuration.LibraryConfiguration;
import designpatterns.DesignPatternsObject;

public class DesignPatternsConfiguration extends DesignPatternsObject implements OrionConfiguration
{
    private static boolean haveDesignPatternsNotBeenRegistered;
    private static Set<DesignPatternsLibraryConfiguration> designPatternsConfigurationSet;
    
    
    static
    {
        haveDesignPatternsNotBeenRegistered = true;
        designPatternsConfigurationSet = new HashSet<DesignPatternsLibraryConfiguration>();
    }


    public static Set<DesignPatternsLibraryConfiguration> getDesignPatternsConfigurationSet()
    {
        return designPatternsConfigurationSet;
    }
    
    
    public static synchronized void registerDesignPatternsConfiguration(DesignPatternsLibraryConfiguration designPatternsLibraryConfiguration)
    {
        if(haveDesignPatternsNotBeenRegistered)
        {
            getDesignPatternsConfigurationSet().add(designPatternsLibraryConfiguration);
            
            if(designPatternsConfigurationSet.contains(designPatternsLibraryConfiguration))
            {
                haveDesignPatternsNotBeenRegistered = false;
            }
        }
        else if(!designPatternsConfigurationSet.contains(designPatternsLibraryConfiguration))
        {
            getDesignPatternsConfigurationSet().add(designPatternsLibraryConfiguration);
        }
    }
}
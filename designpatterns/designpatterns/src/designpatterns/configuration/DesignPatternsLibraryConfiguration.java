package designpatterns.configuration;

import java.util.HashSet;
import java.util.Set;
import core.abstraction.OrionConfiguration;
import core.configuration.CoreConfigurationEnumeration;
import core.configuration.LibraryConfiguration;
import designpatterns.DesignPatternsObject;

public class DesignPatternsLibraryConfiguration extends DesignPatternsObject implements OrionConfiguration
{
    private PipelineConfiguration pipelineConfiguration;


    public PipelineConfiguration getPipelineConfiguration()
    {
        return this.pipelineConfiguration;
    }


    public void setPipelineConfiguration(PipelineConfiguration pipelineConfiguration)
    {
        this.pipelineConfiguration = pipelineConfiguration;
    }
    
    
    @Override
    public int hashCode()
    {
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + this.getPipelineConfiguration().hashCode();
        return hash;
    }


    @Override
    public boolean equals(Object object)
    {
        if(object == null || object.getClass() != getClass())
        {
            return false;
        }
        else
        {
            DesignPatternsLibraryConfiguration otherDesignPatternsLibraryConfiguration = (DesignPatternsLibraryConfiguration)object;
            
            if(this.getPipelineConfiguration().equals(otherDesignPatternsLibraryConfiguration.getPipelineConfiguration()))
            {
                return true;
            }
        }
        
        return false;
    }
}
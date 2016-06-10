package designpatterns.configuration;

import java.util.List;
import core.abstraction.OrionConfiguration;
import designpatterns.DesignPatternsObject;

public class PipelineConfiguration extends DesignPatternsObject implements OrionConfiguration
{
    private List<Class<?>> allowedClasses;


    public List<Class<?>> getAllowedClasses()
    {
        return this.allowedClasses;
    }


    public void setAllowedClasses(List<Class<?>> allowedClasses)
    {
        this.allowedClasses = allowedClasses;
    }
    
    
    @Override
    public int hashCode()
    {
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + this.getAllowedClasses().hashCode();
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
            PipelineConfiguration otherPipelineConfiguration = (PipelineConfiguration)object;
            
            if(this.getAllowedClasses().equals(otherPipelineConfiguration.getAllowedClasses()))
            {
                return true;
            }
        }
        
        return false;
    }
}
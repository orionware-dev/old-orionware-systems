package designpatterns.configuration;

import java.util.ArrayList;
import java.util.List;
import core.OrionSimpleObject;
import core.abstraction.OrionConfiguration;

public class PipelineConfiguration extends OrionSimpleObject implements OrionConfiguration
{
    private List<String> allowedClassesNames;


    public PipelineConfiguration()
    {
        this.allowedClassesNames = new ArrayList<String>();
    }


    public List<String> getAllowedClassesNames()
    {
        return this.allowedClassesNames;
    }


    public void setAllowedClassesNames(List<String> allowedClassesNames)
    {
        this.allowedClassesNames = allowedClassesNames;
    }


    @Override
    public int hashCode()
    {
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + this.getAllowedClassesNames().hashCode();
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

            if(this.getAllowedClassesNames().equals(otherPipelineConfiguration.getAllowedClassesNames()))
            {
                return true;
            }
        }

        return false;
    }
}
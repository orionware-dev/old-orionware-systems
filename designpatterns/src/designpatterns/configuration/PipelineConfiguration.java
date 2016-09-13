package designpatterns.configuration;

import core.OrionSimpleObject;
import core.abstraction.OrionConfiguration;
import datastructures.lists.OrionList;
import datastructures.lists.impl.OrionArrayList;

public class PipelineConfiguration extends OrionSimpleObject implements OrionConfiguration
{
    private OrionList<String> allowedClassesNames;


    public PipelineConfiguration()
    {
        this.allowedClassesNames = new OrionArrayList<String>();
    }


    public OrionList<String> getAllowedClassesNames()
    {
        return this.allowedClassesNames;
    }


    public void setAllowedClassesNames(OrionList<String> allowedClassesNames)
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
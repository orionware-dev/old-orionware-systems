package designpatterns.configuration;

import java.util.Map;
import core.OrionSimpleObject;
import core.abstraction.OrionConfiguration;

public class PipelineConfiguration extends OrionSimpleObject implements OrionConfiguration
{
    private Map<Class<?>, String> allowedClassesAndMethodsMapper;


    public Map<Class<?>, String> getAllowedClassesAndMethodsMapper()
    {
        return this.allowedClassesAndMethodsMapper;
    }


    public void setAllowedClassesAndMethodsMapper(Map<Class<?>, String> allowedClassesAndMethodsMapper)
    {
        this.allowedClassesAndMethodsMapper = allowedClassesAndMethodsMapper;
    }


    @Override
    public int hashCode()
    {
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + this.getAllowedClassesAndMethodsMapper().hashCode();
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

            if(this.getAllowedClassesAndMethodsMapper().equals(otherPipelineConfiguration.getAllowedClassesAndMethodsMapper()))
            {
                return true;
            }
        }

        return false;
    }
}
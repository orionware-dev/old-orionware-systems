package core.configuration;

import core.OrionSimpleObject;
import core.abstraction.OrionConfiguration;

public class LibraryConfiguration extends OrionSimpleObject implements OrionConfiguration
{
    private String libraryName;
    private String libraryClassPath;
    private String configurationFilePath;
    private String annotationsDefinitionFilePath;
    

    public String getLibraryName()
    {
        return this.libraryName;
    }


    public void setLibraryName(String libraryName)
    {
        this.libraryName = libraryName;
    }


    public String getLibraryClassPath()
    {
        return this.libraryClassPath;
    }


    public void setLibraryClassPath(String libraryClassPath)
    {
        this.libraryClassPath = libraryClassPath;
    }


    public String getConfigurationFilePath()
    {
        return this.configurationFilePath;
    }


    public void setConfigurationFilePath(String configurationFilePath)
    {
        this.configurationFilePath = configurationFilePath;
    }


    public String getAnnotationsDefinitionFilePath()
    {
        return this.annotationsDefinitionFilePath;
    }


    public void setAnnotationsDefinitionFilePath(String annotationsDefinitionFilePath)
    {
        this.annotationsDefinitionFilePath = annotationsDefinitionFilePath;
    }
    
    
    @Override
    public int hashCode()
    {
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + this.getLibraryName().hashCode();
        hash = defaultPrimeNumberForHashing * hash + this.getLibraryClassPath().hashCode();
        hash = defaultPrimeNumberForHashing * hash + this.getConfigurationFilePath().hashCode();
        hash = defaultPrimeNumberForHashing * hash + this.getAnnotationsDefinitionFilePath().hashCode();
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
            LibraryConfiguration otherLibraryConfiguration = (LibraryConfiguration)object;
            
            if(this.getLibraryName().equals(otherLibraryConfiguration.getLibraryName())
                   && this.getLibraryClassPath().equals(otherLibraryConfiguration.getLibraryClassPath())
                   && this.getConfigurationFilePath().equals(otherLibraryConfiguration.getConfigurationFilePath())
                   && this.getAnnotationsDefinitionFilePath().equals(otherLibraryConfiguration.getAnnotationsDefinitionFilePath()))
            {
                return true;
            }
        }
        
        return false;
    }
}
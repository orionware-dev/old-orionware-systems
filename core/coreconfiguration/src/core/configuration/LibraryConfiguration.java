package core.configuration;

import core.OrionSimpleObject;
import core.abstraction.OrionConfiguration;

public class LibraryConfiguration extends OrionSimpleObject implements OrionConfiguration
{
    private String libraryName;
    private String libraryClassPath;
    private String libraryConfigurationDir;
    private String configurationFilePath;
    private String configurationFileName;
    private String annotationsDefinitionFilePath;
    private String annotationsDefinitionFileName;
    private String integrationTestsClassPath;
    private String unitTestsClassPath;
    
    
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
    
    
    public String getLibraryConfigurationDir()
    {
        return this.libraryConfigurationDir;
    }


    public void setLibraryConfigurationDir(String libraryConfigurationDir)
    {
        this.libraryConfigurationDir = libraryConfigurationDir;
    }


    public String getConfigurationFilePath()
    {
        return this.configurationFilePath;
    }


    public void setConfigurationFilePath(String configurationFilePath)
    {
        this.configurationFilePath = configurationFilePath;
    }


    public String getConfigurationFileName()
    {
        return this.configurationFileName;
    }


    public void setConfigurationFileName(String configurationFileName)
    {
        this.configurationFileName = configurationFileName;
    }


    public String getAnnotationsDefinitionFilePath()
    {
        return this.annotationsDefinitionFilePath;
    }


    public void setAnnotationsDefinitionFilePath(String annotationsDefinitionFilePath)
    {
        this.annotationsDefinitionFilePath = annotationsDefinitionFilePath;
    }


    public String getAnnotationsDefinitionFileName()
    {
        return this.annotationsDefinitionFileName;
    }


    public void setAnnotationsDefinitionFileName(String annotationsDefinitionFileName)
    {
        this.annotationsDefinitionFileName = annotationsDefinitionFileName;
    }


    public String getIntegrationTestsClassPath()
    {
        return this.integrationTestsClassPath;
    }


    public void setIntegrationTestsClassPath(String integrationTestsClassPath)
    {
        this.integrationTestsClassPath = integrationTestsClassPath;
    }


    public String getUnitTestsClassPath()
    {
        return this.unitTestsClassPath;
    }


    public void setUnitTestsClassPath(String unitTestsClassPath)
    {
        this.unitTestsClassPath = unitTestsClassPath;
    }
    
    
    @Override
    public int hashCode()
    {
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + this.getLibraryName().hashCode();
        hash = defaultPrimeNumberForHashing * hash + this.getLibraryClassPath().hashCode();
        hash = defaultPrimeNumberForHashing * hash + this.getLibraryConfigurationDir().hashCode();
        hash = defaultPrimeNumberForHashing * hash + this.getConfigurationFilePath().hashCode();
        hash = defaultPrimeNumberForHashing * hash + this.getConfigurationFileName().hashCode();
        hash = defaultPrimeNumberForHashing * hash + this.getAnnotationsDefinitionFilePath().hashCode();
        hash = defaultPrimeNumberForHashing * hash + this.getAnnotationsDefinitionFileName().hashCode();
        hash = defaultPrimeNumberForHashing * hash + this.getIntegrationTestsClassPath().hashCode();
        hash = defaultPrimeNumberForHashing * hash + this.getUnitTestsClassPath().hashCode();
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
                   && this.getLibraryConfigurationDir().equals(otherLibraryConfiguration.getLibraryConfigurationDir())
                   && this.getConfigurationFilePath().equals(otherLibraryConfiguration.getConfigurationFilePath())
                   && this.getConfigurationFileName().equals(otherLibraryConfiguration.getConfigurationFileName())
                   && this.getAnnotationsDefinitionFilePath().equals(otherLibraryConfiguration.getAnnotationsDefinitionFilePath())
                   && this.getAnnotationsDefinitionFileName().equals(otherLibraryConfiguration.getAnnotationsDefinitionFileName())
                   && this.getIntegrationTestsClassPath().equals(otherLibraryConfiguration.getIntegrationTestsClassPath())
                   && this.getUnitTestsClassPath().equals(otherLibraryConfiguration.getUnitTestsClassPath()))
            {
                return true;
            }
        }
        
        return false;
    }
}
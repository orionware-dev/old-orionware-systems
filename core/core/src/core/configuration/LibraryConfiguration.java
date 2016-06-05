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
}
package core.configuration;

import core.general.OrionConfiguration;

public class LibraryConfiguration extends OrionConfiguration implements ConfigurationTriple<String, String, String>
{
    private String libraryName;
    private String libraryClassPath;
    private String configurationFilePath;
    private String annotationsFilePath;


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


    public String getAnnotationsFilePath()
    {
        return this.annotationsFilePath;
    }


    public void setAnnotationsFilePath(String annotationsFilePath)
    {
        this.annotationsFilePath = annotationsFilePath;
    }
}
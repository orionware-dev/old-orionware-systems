package designpatterns;

import core.OrionObject;
import core.configuration.LibraryConfiguration;

public abstract class DesignPatternsObject extends OrionObject
{
    public DesignPatternsObject()
    {
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        libraryConfiguration.setLibraryName("designpatterns");
        libraryConfiguration.setConfigurationFilePath("/configuration/Pipeline.prop");
        registerLibraryConfiguration(libraryConfiguration);
        processAllLibrariesConfiguration();
    }
}
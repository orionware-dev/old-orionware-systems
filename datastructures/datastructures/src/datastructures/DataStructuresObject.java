package datastructures;

import core.OrionObject;
import core.configuration.LibraryConfiguration;

public abstract class DataStructuresObject extends OrionObject
{
    public DataStructuresObject()
    {
        String configurationName = "configuration";
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        libraryConfiguration.setLibraryName("datastructures");
        libraryConfiguration.setLibraryClassPath("/" + libraryConfiguration.getLibraryName());
        libraryConfiguration.setConfigurationFilePath("/" + libraryConfiguration.getLibraryName() + "/" + configurationName + "/DataStructures.prop");
        libraryConfiguration.setAnnotationsFilePath("/" + libraryConfiguration.getLibraryName() + "/" + configurationName + "/DataStructuresAnnotations.prop");
        registerLibraryConfiguration(libraryConfiguration);
        processAllLibrariesConfiguration();
    }
}
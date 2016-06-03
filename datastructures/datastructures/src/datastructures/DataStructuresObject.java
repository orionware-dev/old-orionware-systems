package datastructures;

import core.configuration.LibraryConfiguration;
import core.objects.OrionObject;

public abstract class DataStructuresObject extends OrionObject
{
    public DataStructuresObject()
    {
        String configurationName = "configuration";
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        libraryConfiguration.setLibraryName("datastructures");
        libraryConfiguration.setLibraryClassPath("/" + libraryConfiguration.getLibraryName());
        libraryConfiguration.setConfigurationFilePath(libraryConfiguration.getLibraryClassPath() + "/" + configurationName + "/DataStructures.prop");
        libraryConfiguration.setAnnotationsDefinitionFilePath(libraryConfiguration.getLibraryClassPath() + "/" + configurationName + "/DataStructuresAnnotations.prop");
        registerLibraryConfiguration(libraryConfiguration);
        processAllLibrariesConfiguration();
    }
}
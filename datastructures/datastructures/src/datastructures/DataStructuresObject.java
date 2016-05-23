package datastructures;

import core.OrionObject;
import core.configuration.LibraryConfiguration;

public abstract class DataStructuresObject extends OrionObject
{
    public DataStructuresObject()
    {
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        libraryConfiguration.setLibraryName("datastructures");
        libraryConfiguration.setLibraryClassPath("/" + libraryConfiguration.getLibraryName());
        libraryConfiguration.setConfigurationFilePath("/" + libraryConfiguration.getLibraryName() + "/configuration/DataStructures.prop");
        libraryConfiguration.setAnnotationsFilePath("/" + libraryConfiguration.getLibraryName() + "/configuration/DataStructuresAnnotations.prop");
        registerLibraryConfiguration(libraryConfiguration);
        processAllLibrariesConfiguration();
    }
}
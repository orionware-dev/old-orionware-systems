package datastructures;

import core.OrionObject;
import core.configuration.LibraryConfiguration;

public abstract class DataStructuresObject extends OrionObject
{
    public DataStructuresObject()
    {
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        libraryConfiguration.setLibraryName("datastructures");
        libraryConfiguration.setConfigurationFilePath("/configuration/DataStructures.prop");
        libraryConfiguration.setAnnotationsFilePath("/configuration/DataStructuresAnnotations.prop");
        librariesConfigurationSet.add(libraryConfiguration);
        processAllLibrariesConfiguration();
    }
}
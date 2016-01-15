package datastructures;

import core.OrionObject;
import core.configuration.LibraryConfiguration;

public abstract class DataStructureObject extends OrionObject
{
    public DataStructureObject()
    {
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        libraryConfiguration.setLibraryName("datastructures");
        libraryConfiguration.setConfigurationFilePath("/configuration/DataStructures.prop");
        libraryConfiguration.setAnnotationsFilePath("/configuration/DataStructuresAnnotations.prop");
        librariesConfigurationSet.add(libraryConfiguration);
        processAllLibrariesConfiguration();
    }
}
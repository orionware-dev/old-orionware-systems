package datastructuresservices;

import core.configuration.LibraryConfiguration;
import datastructures.DataStructureObject;

public abstract class DataStructureServiceObject extends DataStructureObject
{
    public DataStructureServiceObject()
    {
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        libraryConfiguration.setLibraryName("datastructuresservices");
        libraryConfiguration.setConfigurationFilePath("/configuration/DataStructuresServices.prop");
        libraryConfiguration.setAnnotationsFilePath("/configuration/DataStructuresServicesAnnotations.prop");
        librariesConfigurationSet.add(libraryConfiguration);
        processAllLibrariesConfiguration();
    }
}
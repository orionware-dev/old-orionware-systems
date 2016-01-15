package datastructuresservices;

import core.configuration.LibraryConfiguration;
import datastructures.DataStructureObject;

public abstract class DataStructureServiceObject extends DataStructureObject
{
    public DataStructureServiceObject()
    {
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        libraryConfiguration.setLibraryName("datastructuresservices");
        librariesConfigurationSet.add(libraryConfiguration);
        processAllLibrariesConfiguration();
    }
}
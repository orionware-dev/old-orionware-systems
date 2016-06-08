package datastructuresservices;

import core.configuration.LibraryConfiguration;
import datastructures.DataStructuresObject;

public abstract class DataStructuresServicesObject extends DataStructuresObject
{
    public DataStructuresServicesObject()
    {
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        libraryConfiguration.setLibraryName("datastructuresservices");
        libraryConfiguration.setLibraryClassPath("/datastructures/services");
        registerLibraryConfiguration(libraryConfiguration);
        processAllLibrariesConfiguration();
    }
}
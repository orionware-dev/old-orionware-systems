package datastructures.services;

import datastructures.DataStructuresObject;
import datastructures.services.configuration.DataStructuresServicesConfigurationEnumeration;

public abstract class DataStructuresServicesObject extends DataStructuresObject
{
    public DataStructuresServicesObject()
    {
        /*LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        libraryConfiguration.setLibraryName("datastructuresservices");
        libraryConfiguration.setLibraryClassPath("/datastructures/services");
        registerLibraryConfiguration(libraryConfiguration);*/
        registerLibraryConfiguration(DataStructuresServicesConfigurationEnumeration.class.getName());
        processAllLibrariesConfiguration();
    }
}
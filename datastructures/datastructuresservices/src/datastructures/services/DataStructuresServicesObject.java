package datastructures.services;

import core.configuration.LibraryConfiguration;
import datastructures.DataStructuresObject;
import datastructures.configuration.DataStructuresConfigurationEnumeration;
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
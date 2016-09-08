package datastructures.services;

import datastructures.DataStructuresObject;
import datastructures.services.configuration.DataStructuresServicesConfigurationEnumeration;

public abstract class DataStructuresServicesObject extends DataStructuresObject
{
    public DataStructuresServicesObject()
    {
        registerLibraryConfiguration(DataStructuresServicesConfigurationEnumeration.class.getName());
        processAllLibrariesConfiguration();
    }
}
package datastructures.facades;

import core.configuration.LibraryConfiguration;
import datastructures.DataStructuresObject;
import datastructures.facades.configuration.DataStructuresFacadesConfigurationEnumeration;
import datastructures.services.configuration.DataStructuresServicesConfigurationEnumeration;

public abstract class DataStructuresFacadesObject extends DataStructuresObject
{
    public DataStructuresFacadesObject()
    {
        /*LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        libraryConfiguration.setLibraryName("datastructuresfacades");
        libraryConfiguration.setLibraryClassPath("/datastructures/facades");
        registerLibraryConfiguration(libraryConfiguration);*/
        registerLibraryConfiguration(DataStructuresFacadesConfigurationEnumeration.class.getName());
        processAllLibrariesConfiguration();
    }
}
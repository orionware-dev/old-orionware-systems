package datastructures.facades;

import datastructures.DataStructuresObject;
import datastructures.facades.configuration.DataStructuresFacadesConfigurationEnumeration;

public abstract class DataStructuresFacadesObject extends DataStructuresObject
{
    public DataStructuresFacadesObject()
    {
        /*
         * LibraryConfiguration libraryConfiguration = new
         * LibraryConfiguration();
         * libraryConfiguration.setLibraryName("datastructuresfacades");
         * libraryConfiguration.setLibraryClassPath("/datastructures/facades");
         * registerLibraryConfiguration(libraryConfiguration);
         */
        registerLibraryConfiguration(DataStructuresFacadesConfigurationEnumeration.class.getName());
        processAllLibrariesConfiguration();
    }
}
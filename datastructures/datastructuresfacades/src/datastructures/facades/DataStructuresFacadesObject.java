package datastructures.facades;

import datastructures.DataStructuresObject;
import datastructures.facades.configuration.DataStructuresFacadesConfigurationEnumeration;

public abstract class DataStructuresFacadesObject extends DataStructuresObject
{
    public DataStructuresFacadesObject()
    {
        registerLibraryConfiguration(DataStructuresFacadesConfigurationEnumeration.class.getName());
        processAllLibrariesConfiguration();
    }
}
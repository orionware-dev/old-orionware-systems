package datastructuresfacades;

import core.configuration.LibraryConfiguration;
import datastructures.DataStructuresObject;

public abstract class DataStructuresFacadesObject extends DataStructuresObject
{
    public DataStructuresFacadesObject()
    {
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        libraryConfiguration.setLibraryName("datastructuresfacades");
        registerLibraryConfiguration(libraryConfiguration);
        processAllLibrariesConfiguration();
    }
}
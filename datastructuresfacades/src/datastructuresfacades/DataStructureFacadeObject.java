package datastructuresfacades;

import core.configuration.LibraryConfiguration;
import datastructures.DataStructureObject;

public abstract class DataStructureFacadeObject extends DataStructureObject
{
    public DataStructureFacadeObject()
    {
        LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
        libraryConfiguration.setLibraryName("datastructuresfacades");
        librariesConfigurationSet.add(libraryConfiguration);
        processAllLibrariesConfiguration();
    }
}
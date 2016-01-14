package datastructures;

import java.util.Set;
import core.OrionObject;
import core.configuration.LibraryConfiguration;
import core.general.Triple;

public abstract class DataStructureObject extends OrionObject
{
    public DataStructureObject()
    {
        LibraryConfiguration libraryConfigurationTriple = new LibraryConfiguration();
        libraryConfigurationTriple.setLibraryName("datastructures");
        libraryConfigurationTriple.setConfigurationFilePath("/configuration/DataStructures.prop");
        libraryConfigurationTriple.setAnnotationsFilePath("/configuration/DataStructuresAnnotations.prop");
        libraryNamesAndConfigurationFilePathsAndAnnotationsFilePaths.add(libraryConfigurationTriple);
    }
}
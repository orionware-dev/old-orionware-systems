package datastructures;

import java.util.Set;
import core.OrionObject;
import core.general.Triple;

public abstract class DataStructureObject extends OrionObject
{
    public DataStructureObject()
    {
        
        libraryNamesAndConfigurationFilePathsAndAnnotationsFilePaths.add(arg0);
        super("datastructures", "/configuration/DataStructures.prop", "/configuration/DataStructuresAnnotations.prop");
    }
    
    
    public DataStructureObject(String libraryName, String libraryConfigurationFilePath, String libraryAnnotationsFilePath)
    {
        this();
        Set<Triple<String, String, String>> libraryNamesAndConfigurationFilePathsAndAnnotationsFilePaths;
        super(libraryName, libraryConfigurationFilePath, libraryAnnotationsFilePath);
    }
}
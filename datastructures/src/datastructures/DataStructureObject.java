package datastructures;

import core.OrionObject;

public abstract class DataStructureObject extends OrionObject
{
    public DataStructureObject()
    {
        super("datastructures", "/configuration/DataStructures.prop", "/configuration/DataStructuresAnnotations.prop");
    }
    
    
    public DataStructureObject(String libraryName, String libraryConfigurationFilePath, String libraryAnnotationsFilePath)
    {
        this();
        super(libraryName, libraryConfigurationFilePath, libraryAnnotationsFilePath);
    }
}
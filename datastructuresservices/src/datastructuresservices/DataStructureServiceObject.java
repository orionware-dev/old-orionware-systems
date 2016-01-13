package datastructuresservices;

import datastructures.DataStructureObject;

public abstract class DataStructureServiceObject extends DataStructureObject
{
    public DataStructureServiceObject()
    {
        super("datastructuresservices", "/configuration/DataStructuresServices.prop", "/configuration/DataStructuresServicesAnnotations.prop");
    }
}
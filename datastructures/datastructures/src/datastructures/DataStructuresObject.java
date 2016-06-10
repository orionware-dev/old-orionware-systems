package datastructures;

import core.objects.OrionObject;
import datastructures.configuration.DataStructuresConfigurationEnumeration;

public abstract class DataStructuresObject extends OrionObject
{
    public DataStructuresObject()
    {
        registerLibraryConfiguration(DataStructuresConfigurationEnumeration.class.getName());
        processAllLibrariesConfiguration();
    }
}
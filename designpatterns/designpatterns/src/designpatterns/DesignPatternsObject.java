package designpatterns;

import core.configuration.LibraryConfiguration;
import core.objects.OrionObject;
import datastructures.configuration.DataStructuresConfigurationEnumeration;
import designpatterns.configuration.DesignPatternsConfigurationEnumeration;

public abstract class DesignPatternsObject extends OrionObject
{
    public DesignPatternsObject()
    {
        registerLibraryConfiguration(DesignPatternsConfigurationEnumeration.class.getName());
        processAllLibrariesConfiguration();
    }
}
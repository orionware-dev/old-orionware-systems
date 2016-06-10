package designpatterns.facades;

import core.objects.OrionObject;
import designpatterns.facades.configuration.DesignPatternsFacadesConfigurationEnumeration;

public abstract class DesignPatternsFacadesObject extends OrionObject
{
    public DesignPatternsFacadesObject()
    {
        registerLibraryConfiguration(DesignPatternsFacadesConfigurationEnumeration.class.getName());
        processAllLibrariesConfiguration();
    }
}
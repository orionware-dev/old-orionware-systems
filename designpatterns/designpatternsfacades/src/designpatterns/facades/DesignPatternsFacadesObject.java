package designpatterns.facades;

import core.configuration.LibraryConfiguration;
import core.objects.OrionObject;
import designpatterns.configuration.DesignPatternsConfigurationEnumeration;
import designpatterns.facades.configuration.DesignPatternsFacadesConfigurationEnumeration;

public abstract class DesignPatternsFacadesObject extends OrionObject
{
    public DesignPatternsFacadesObject()
    {
        registerLibraryConfiguration(DesignPatternsFacadesConfigurationEnumeration.class.getName());
        processAllLibrariesConfiguration();
    }
}
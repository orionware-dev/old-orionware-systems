package designpatterns.facades;

import designpatterns.DesignPatternsObject;
import designpatterns.facades.configuration.DesignPatternsFacadesConfigurationEnumeration;

public abstract class DesignPatternsFacadesObject extends DesignPatternsObject
{
    public DesignPatternsFacadesObject()
    {
        registerLibraryConfiguration(DesignPatternsFacadesConfigurationEnumeration.class.getName());
        processAllLibrariesConfiguration();
    }
}
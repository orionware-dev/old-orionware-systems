package designpatterns.services;

import core.configuration.LibraryConfiguration;
import core.objects.OrionObject;
import designpatterns.configuration.DesignPatternsConfigurationEnumeration;
import designpatterns.services.configuration.DesignPatternsServicesConfigurationEnumeration;

public abstract class DesignPatternsServicesObject extends OrionObject
{
    public DesignPatternsServicesObject()
    {
        registerLibraryConfiguration(DesignPatternsServicesConfigurationEnumeration.class.getName());
        processAllLibrariesConfiguration();
    }
}
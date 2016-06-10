package designpatterns.services;

import core.objects.OrionObject;
import designpatterns.services.configuration.DesignPatternsServicesConfigurationEnumeration;

public abstract class DesignPatternsServicesObject extends OrionObject
{
    public DesignPatternsServicesObject()
    {
        registerLibraryConfiguration(DesignPatternsServicesConfigurationEnumeration.class.getName());
        processAllLibrariesConfiguration();
    }
}
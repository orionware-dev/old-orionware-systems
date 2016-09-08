package designpatterns.services;

import designpatterns.DesignPatternsObject;
import designpatterns.services.configuration.DesignPatternsServicesConfigurationEnumeration;

public abstract class DesignPatternsServicesObject extends DesignPatternsObject
{
    public DesignPatternsServicesObject()
    {
        registerLibraryConfiguration(DesignPatternsServicesConfigurationEnumeration.class.getName());
        processAllLibrariesConfiguration();
    }
}
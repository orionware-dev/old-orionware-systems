package designpatterns;

import core.objects.OrionObject;
import designpatterns.configuration.DesignPatternsConfigurationEnumeration;
import designpatterns.configuration.DesignPatternsInternalConfiguration;
import designpatterns.designpatternsobject.impl.DesignPatternsObjectProcessorServiceImpl;

public abstract class DesignPatternsObject extends OrionObject
{
    public DesignPatternsObject()
    {
        registerLibraryConfiguration(DesignPatternsConfigurationEnumeration.class.getName());
        boolean haveDesignPatternsConfigurationBeenRegistered = new DesignPatternsObjectProcessorServiceImpl().registerDesignPatternsConfiguration();
        DesignPatternsInternalConfiguration.haveDesignPatternsConfigurationNotBeenRegistered = haveDesignPatternsConfigurationBeenRegistered;
    }
}
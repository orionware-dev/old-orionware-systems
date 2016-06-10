package designpatterns;

import core.configuration.LibrariesConfiguration;
import core.configuration.LibraryConfiguration;
import core.objects.OrionObject;
import designpatterns.configuration.DesignPatternsConfigurationEnumeration;
import designpatterns.services.designpatternsobject.DesignPatternsObjectProcessorService;
import designpatterns.services.designpatternsobject.impl.tasks.DesignPatternsObjectProcessorServiceImpl;

public abstract class DesignPatternsObject extends OrionObject
{
    private DesignPatternsObjectProcessorService designPatternsObjectProcessorService;
    
    
    public DesignPatternsObject()
    {
        registerLibraryConfiguration(DesignPatternsConfigurationEnumeration.class.getName());
        processAllLibrariesConfiguration();
        this.designPatternsObjectProcessorService = new DesignPatternsObjectProcessorServiceImpl(this);
    }
    
    
    protected void registerLibraryConfiguration(String libraryConfigurationEnumerationClassPath)
    {
        LibraryConfiguration libraryConfiguration = orionObjectProcessorService.convertConfigurationEnumerationToLibraryConfiguration(libraryConfigurationEnumerationClassPath);
        LibrariesConfiguration.registerLibraryConfiguration(libraryConfiguration);
    }
    
    
    protected void processAllLibrariesConfiguration()
    {
        orionObjectProcessorService.processAllLibrariesConfiguration(this);
    }
}
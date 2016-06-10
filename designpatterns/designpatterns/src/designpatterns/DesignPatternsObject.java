package designpatterns;

import core.configuration.LibrariesConfiguration;
import core.configuration.LibrariesConfigurationMapper;
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
        LibrariesConfigurationMapper.LIBRARIES_AND_IF_CONFIGURATION_HAVE_BEEN_REGISTERED_MAPPER.put(DesignPatternsConfigurationEnumeration.LIBRARY_CLASS_PATH.get(), true);
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
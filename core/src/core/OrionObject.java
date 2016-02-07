package core;

import java.util.HashSet;
import java.util.Set;
import core.annotations.loader.AnnotationsLoaderService;
import core.annotations.loader.AnnotationsLoaderServiceImpl;
import core.annotations.processor.AnnotationsProcessorService;
import core.annotations.processor.AnnotationsProcessorServiceImpl;
import core.annotations.registry.AnnotationsRegistrationService;
import core.annotations.registry.AnnotationsRegistrationServiceImpl;
import core.configuration.ConfigurationService;
import core.configuration.ConfigurationServiceImpl;
import core.configuration.CoreConfigurationEnum;
import core.configuration.LibraryConfiguration;
import core.libraries.LibraryService;
import core.libraries.LibraryServiceImpl;

public abstract class OrionObject
{
    protected Set<LibraryConfiguration> librariesConfigurationSet = new HashSet<LibraryConfiguration>();
    private LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
    private LibraryService libraryService = new LibraryServiceImpl();
    private ConfigurationService configurationService = new ConfigurationServiceImpl();
    private AnnotationsRegistrationService annotationsRegistrationService = new AnnotationsRegistrationServiceImpl();
    private AnnotationsProcessorService annotationsProcessorService = new AnnotationsProcessorServiceImpl();
    
    
    public OrionObject()
    {
        initialiseCoreConfiguration();
        loadCoreConfiguration();
        processAllLibrariesConfigurationIfItIsTheCoreLibrary();
    }
    
    
    private void initialiseCoreConfiguration()
    {
        libraryConfiguration.setLibraryName(CoreConfigurationEnum.LIBRARY_NAME.get());
        libraryConfiguration.setConfigurationFilePath(CoreConfigurationEnum.PROPERTIES_FILE_PATH.get());
        libraryConfiguration.setAnnotationsFilePath(CoreConfigurationEnum.ANNOTATIONS_DEFINITION_FILE_PATH.get());
    }
    
    
    private void loadCoreConfiguration()
    {
        librariesConfigurationSet.add(libraryConfiguration);
    }
    
    
    //this method is called by this constructor if only the core is running.
    //If another library is running like datastructures, then that constructor
    //will call this method so that all the libraries configs are loaded in one go
    private void processAllLibrariesConfigurationIfItIsTheCoreLibrary()
    {
        if(thisIsCoreLibrary())
        {
            processAllLibrariesConfiguration();
        }
    }
    
    
    private boolean thisIsCoreLibrary()
    {
        return libraryService.isCoreLibrary(getClass());
    }
    
    
    protected void processAllLibrariesConfiguration()
    {
        configurationService.loadLibrariesProperties(librariesConfigurationSet);
        annotationsRegistrationService.registerLibrariesAnnotations(librariesConfigurationSet);
        annotationsProcessorService.processAllAnnotations(this);
    }
}
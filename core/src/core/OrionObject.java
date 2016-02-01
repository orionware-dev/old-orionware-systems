package core;

import java.util.HashSet;
import java.util.Set;
import core.annotations.configuration.AnnotationsConfigurationService;
import core.annotations.configuration.AnnotationsConfigurationServiceImpl;
import core.annotations.processor.AnnotationsProcessorService;
import core.annotations.processor.AnnotationsProcessorServiceImpl;
import core.configuration.ConfigurationService;
import core.configuration.ConfigurationServiceImpl;
import core.configuration.CoreConfigurationEnum;
import core.configuration.LibraryConfiguration;
import core.libraries.LibraryService;
import core.libraries.LibraryServiceImpl;

public abstract class OrionObject
{
    protected Set<LibraryConfiguration> librariesConfigurationSet;
    private LibraryConfiguration libraryConfiguration;
    private LibraryService libraryService;
    private ConfigurationService configurationService;
    private AnnotationsConfigurationService annotationsConfigurationService;
    private AnnotationsProcessorService annotationsProcessorService;
    
    
    public OrionObject()
    {
        initialiseDependencies();
        initialiseCoreConfiguration();
        loadCoreConfiguration();
        processAllLibrariesConfigurationIfItIsTheCoreLibrary();
    }
    
    
    private void initialiseDependencies()
    {
        this.librariesConfigurationSet = new HashSet<LibraryConfiguration>();
        this.libraryConfiguration = new LibraryConfiguration();
        this.libraryService = new LibraryServiceImpl();
        this.configurationService = new ConfigurationServiceImpl();
        this.annotationsConfigurationService = new AnnotationsConfigurationServiceImpl();
        this.annotationsProcessorService = new AnnotationsProcessorServiceImpl();
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
        if(libraryService.isCoreLibrary(getClass()))
        {
            processAllLibrariesConfiguration();
        }
    }
    
    
    protected void processAllLibrariesConfiguration()
    {
        configurationService.loadLibrariesProperties(librariesConfigurationSet);
        annotationsConfigurationService.loadLibrariesAnnotations(librariesConfigurationSet);
        annotationsProcessorService.processAllAnnotations(this);
    }
}
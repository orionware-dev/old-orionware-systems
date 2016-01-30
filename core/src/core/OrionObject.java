package core;

import java.util.Set;
import core.annotations.configuration.AnnotationsConfigurationService;
import core.annotations.processor.AnnotationsProcessorService;
import core.configuration.ConfigurationService;
import core.configuration.CoreConfigurationEnum;
import core.configuration.LibraryConfiguration;
import core.libraries.LibraryService;

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
        new OrionObjectDependenciesBuilder().injectDependencies(this);
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


    public void setLibrariesConfigurationSet(Set<LibraryConfiguration> librariesConfigurationSet)
    {
        this.librariesConfigurationSet = librariesConfigurationSet;
    }


    public void setLibraryConfiguration(LibraryConfiguration libraryConfiguration)
    {
        this.libraryConfiguration = libraryConfiguration;
    }


    public void setLibraryService(LibraryService libraryService)
    {
        this.libraryService = libraryService;
    }


    public void setConfigurationService(ConfigurationService configurationService)
    {
        this.configurationService = configurationService;
    }


    public void setAnnotationsConfigurationService(AnnotationsConfigurationService annotationsConfigurationService)
    {
        this.annotationsConfigurationService = annotationsConfigurationService;
    }


    public void setAnnotationsProcessorService(AnnotationsProcessorService annotationsProcessorService)
    {
        this.annotationsProcessorService = annotationsProcessorService;
    }
}
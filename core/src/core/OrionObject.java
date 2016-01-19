package core;

import java.util.Set;
import core.annotations.AnnotationsService;
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
    private AnnotationsService annotationsService;
    
    
    public OrionObject()
    {
        new OrionObjectDependenciesBuilder().injectDependencies(this);
        //librariesConfigurationSet = new HashSet<LibraryConfiguration>();
        loadCoreConfiguration(initialiseCoreConfiguration());
        processAllLibrariesConfigurationIfItIsTheCoreLibrary();
    }
    
    
    private LibraryConfiguration initialiseCoreConfiguration()
    {
        libraryConfiguration.setLibraryName(CoreConfigurationEnum.LIBRARY_NAME.get());
        libraryConfiguration.setConfigurationFilePath(CoreConfigurationEnum.PROPERTIES_FILE_PATH.get());
        libraryConfiguration.setAnnotationsFilePath(CoreConfigurationEnum.ANNOTATIONS_DEFINITION_FILE_PATH.get());
        return libraryConfiguration;
    }
    
    
    private void loadCoreConfiguration(LibraryConfiguration libraryConfiguration)
    {
        librariesConfigurationSet.add(libraryConfiguration);
    }
    
    
    //this method is called by this constructor if only the core is running.
    //If another library is running like datastructures, then that constructor
    //will call this method so that all the libraries configs are loaded in one go
    protected void processAllLibrariesConfigurationIfItIsTheCoreLibrary()
    {
        if(libraryService.isCoreLibrary(getClass()))
        {
            processAllLibrariesConfiguration();
        }
    }
    
    
    protected void processAllLibrariesConfiguration()
    {
        configurationService.loadLibrariesProperties(librariesConfigurationSet);
        annotationsService.getAnnotationsConfigurationService().loadLibrariesAnnotations(librariesConfigurationSet);
        annotationsService.getAnnotationsProcessorService().processAllAnnotations(this);
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


    public void setAnnotationsService(AnnotationsService annotationsService)
    {
        this.annotationsService = annotationsService;
    }
}
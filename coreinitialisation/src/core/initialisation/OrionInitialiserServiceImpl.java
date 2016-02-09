package core.initialisation;

import java.util.HashSet;
import java.util.Set;
import core.annotations.processor.AnnotationsProcessorService;
import core.annotations.processor.AnnotationsProcessorServiceImpl;
import core.annotations.registry.AnnotationsRegistrationService;
import core.annotations.registry.AnnotationsRegistrationServiceImpl;
import core.configuration.CoreConfigurationEnum;
import core.configuration.LibraryConfiguration;
import core.configuration.classpath.ConfigurationService;
import core.configuration.classpath.ConfigurationServiceImpl;

public class OrionInitialiserServiceImpl implements OrionInitialiserService
{
    private Object OrionObject;
    private Set<LibraryConfiguration> librariesConfigurationSet = new HashSet<LibraryConfiguration>();
    private LibraryConfiguration libraryConfiguration = new LibraryConfiguration();
    private ConfigurationService configurationService = new ConfigurationServiceImpl();
    private AnnotationsRegistrationService annotationsRegistrationService = new AnnotationsRegistrationServiceImpl();
    private AnnotationsProcessorService annotationsProcessorService = new AnnotationsProcessorServiceImpl();
    
    
    @Override
    public void initialiseOrionObject(Object OrionObject)
    {
        this.OrionObject = OrionObject;
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
        return configurationService.isCoreLibrary(getClass());
    }
    
    
    private void processAllLibrariesConfiguration()
    {
        configurationService.loadLibrariesProperties(librariesConfigurationSet);
        annotationsRegistrationService.registerLibrariesAnnotations(librariesConfigurationSet);
        annotationsProcessorService.processAllAnnotations(OrionObject);
    }
    
    
    public void registerLibraryConfiguration(Object libraryConfiguration)
    {
        librariesConfigurationSet.add((LibraryConfiguration)libraryConfiguration);
    }


    @Override
    public void processAllLibrariesConfiguration(Object OrionObject)
    {
        this.OrionObject = OrionObject;
        processAllLibrariesConfiguration();
    }
}
package core;

import core.annotations.configuration.AnnotationsConfigurationService;
import core.annotations.configuration.AnnotationsConfigurationServiceImpl;
import core.annotations.processor.AnnotationsProcessorService;
import core.annotations.processor.AnnotationsProcessorServiceImpl;
import core.configuration.Configuration;
import core.configuration.ConfigurationService;
import core.configuration.ConfigurationServiceImpl;
import core.libraries.LibraryServiceImpl;

public abstract class OrionObject
{
    private ConfigurationService configurationService;
    private AnnotationsConfigurationService annotationsConfigurationService;
    private AnnotationsProcessorService annotationsProcessorService;
    private String libraryConfigurationFilePath;
    private String libraryAnnotationsFilePath;
    private String libraryName;
    
    
    public OrionObject()
    {
        annotationsProcessorService = new AnnotationsProcessorServiceImpl();
        configurationService = new ConfigurationServiceImpl();
        loadCoreProperties();
        annotationsConfigurationService = new AnnotationsConfigurationServiceImpl();
        //load core annotations
        annotationsConfigurationService.loadLibraryAnnotations(libraryName, libraryAnnotationsFilePath);
        
        //if the following condition is true then it means that only the core is running
        //in which case we can process all annotations. Otherwise we do that in
        //the second constructor which is called by another library/project and
        //not the core itself
        if(new LibraryServiceImpl().isCoreLibrary(getClass()))
        {
            annotationsProcessorService.processAllAnnotations(this);
        }
    }
    
    
    private void loadCoreProperties()
    {
        this.libraryName = Configuration.CORE_LIBRARY_NAME;
        this.libraryConfigurationFilePath = Configuration.CORE_PROPERTIES_FILE_PATH;
        this.libraryAnnotationsFilePath = Configuration.CORE_ANNOTATIONS_DEFINITION_FILE_PATH;
        configurationService.loadProperties(libraryName, libraryConfigurationFilePath);
    }
    
    
    public OrionObject(String libraryName, String libraryConfigurationFilePath, String libraryAnnotationsFilePath)
    {
        //call the default constructor to initialise the core
        this();
        //when this constructor is run that means that the object being created
        //belogns to a project other than the core. The following vars are
        //overwritten by the other project, essentially
        this.libraryName = libraryName;
        this.libraryConfigurationFilePath = libraryConfigurationFilePath;
        this.libraryAnnotationsFilePath = libraryAnnotationsFilePath;
        configurationService.loadProperties(libraryName, libraryConfigurationFilePath);
        annotationsConfigurationService.loadLibraryAnnotations(libraryName, libraryAnnotationsFilePath);
        annotationsProcessorService.processAllAnnotations(this);
    }
}
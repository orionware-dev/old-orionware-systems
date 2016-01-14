package core;

import java.util.HashSet;
import java.util.Set;
import core.annotations.configuration.AnnotationsConfigurationService;
import core.annotations.configuration.AnnotationsConfigurationServiceImpl;
import core.annotations.processor.AnnotationsProcessorService;
import core.annotations.processor.AnnotationsProcessorServiceImpl;
import core.configuration.ConfigurationService;
import core.configuration.ConfigurationServiceImpl;
import core.configuration.CoreConfiguration;
import core.configuration.LibraryConfiguration;
import core.general.Triple;
import core.libraries.LibraryServiceImpl;

public abstract class OrionObject
{
    private ConfigurationService configurationService;
    private AnnotationsConfigurationService annotationsConfigurationService;
    private AnnotationsProcessorService annotationsProcessorService;
    private boolean isCoreLibrary;
    protected Set<LibraryConfiguration> libraryNamesAndConfigurationFilePathsAndAnnotationsFilePaths = new HashSet<LibraryConfiguration>();
    
    
    public OrionObject()
    {
        isCoreLibrary = new LibraryServiceImpl().isCoreLibrary(getClass());
        //the core config is loaded. The subclasses did it already
        loadCoreConfigurationTriple();
        annotationsProcessorService = new AnnotationsProcessorServiceImpl();
        configurationService = new ConfigurationServiceImpl();
        configurationService.loadLibrariesProperties(libraryNamesAndConfigurationFilePathsAndAnnotationsFilePaths);
        annotationsConfigurationService = new AnnotationsConfigurationServiceImpl();
        //load core annotations
        
        if(libraryNamesAndConfigurationFilePathsAndAnnotationsFilePaths != null && !libraryNamesAndConfigurationFilePathsAndAnnotationsFilePaths.isEmpty())
        {
            for(Triple<String, String, String> libraryNameAndConfigurationFilePathAndAnnotationsFilePath : libraryNamesAndConfigurationFilePathsAndAnnotationsFilePaths)
            {
                annotationsConfigurationService.loadLibrariesAnnotations(libraryNamesAndConfigurationFilePathsAndAnnotationsFilePaths);
            }
        }
        
        
        //if the following condition is true then it means that only the core is running
        //in which case we can process all annotations. Otherwise we do that in
        //the second constructor which is called by another library/project and
        //not the core itself
        if(new LibraryServiceImpl().isCoreLibrary(getClass()))
        {
            annotationsProcessorService.processAllAnnotations(this);
        }
    }
    
    
    private void loadCoreConfigurationTriple()
    {
        LibraryConfiguration libraryConfigurationTriple = new LibraryConfiguration();
        libraryConfigurationTriple.setLibraryName(CoreConfiguration.CORE_LIBRARY_NAME);
        libraryConfigurationTriple.setConfigurationFilePath(CoreConfiguration.CORE_PROPERTIES_FILE_PATH);
        libraryConfigurationTriple.setAnnotationsFilePath(CoreConfiguration.CORE_ANNOTATIONS_DEFINITION_FILE_PATH);
        libraryNamesAndConfigurationFilePathsAndAnnotationsFilePaths.add(libraryConfigurationTriple);
    }
}
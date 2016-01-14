package core;

import java.util.HashSet;
import java.util.Set;
import core.annotations.configuration.AnnotationsConfigurationServiceImpl;
import core.annotations.processor.AnnotationsProcessorServiceImpl;
import core.configuration.ConfigurationServiceImpl;
import core.configuration.CoreConfiguration;
import core.configuration.LibraryConfiguration;
import core.libraries.LibraryServiceImpl;

public abstract class OrionObject
{
    protected Set<LibraryConfiguration> libraryNamesAndConfigurationFilePathsAndAnnotationsFilePaths = new HashSet<LibraryConfiguration>();
    
    
    public OrionObject()
    {
        loadCoreConfigurationTriple();
        
        if(new LibraryServiceImpl().isCoreLibrary(getClass()))
        {
            processAllLibrariesConfigurations();
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
    
    
    //this method is called by this constructor if only the core is running.
    //If another library is running like datastructures, then that constructor
    //will call this method so that all the libraries configs are loaded in one go
    protected void processAllLibrariesConfigurations()
    {
        new ConfigurationServiceImpl().loadLibrariesProperties(libraryNamesAndConfigurationFilePathsAndAnnotationsFilePaths);
        new AnnotationsConfigurationServiceImpl().loadLibrariesAnnotations(libraryNamesAndConfigurationFilePathsAndAnnotationsFilePaths);
        new AnnotationsProcessorServiceImpl().processAllAnnotations(this);
    }
}
package core;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import core.annotations.configuration.AnnotationsConfigurationService;
import core.annotations.configuration.AnnotationsConfigurationServiceImpl;
import core.annotations.processor.AnnotationsProcessorService;
import core.annotations.processor.AnnotationsProcessorServiceImpl;
import core.configuration.Configuration;
import core.configuration.ConfigurationService;
import core.configuration.ConfigurationServiceImpl;
import core.configuration.LibraryConfiguration;
import core.general.Pair;
import core.general.Triple;
import core.libraries.LibraryServiceImpl;

public abstract class OrionObject
{
    private ConfigurationService configurationService;
    private AnnotationsConfigurationService annotationsConfigurationService;
    private AnnotationsProcessorService annotationsProcessorService;
    protected Set<LibraryConfiguration> libraryNamesAndConfigurationFilePathsAndAnnotationsFilePaths = new HashSet<LibraryConfiguration>();
    
    
    public OrionObject()
    {
        loadCoreConfigurationTriple();
        annotationsProcessorService = new AnnotationsProcessorServiceImpl();
        configurationService = new ConfigurationServiceImpl();
        configurationService.loadProperties(libraryNameAndConfigurationFilePathAndAnnotationsFilePath);
        annotationsConfigurationService = new AnnotationsConfigurationServiceImpl();
        //load core annotations
        
        if(libraryNamesAndConfigurationFilePathsAndAnnotationsFilePaths != null && !libraryNamesAndConfigurationFilePathsAndAnnotationsFilePaths.isEmpty())
        {
            for(Triple<String, String, String> libraryNameAndConfigurationFilePathAndAnnotationsFilePath : libraryNamesAndConfigurationFilePathsAndAnnotationsFilePaths)
            {
                annotationsConfigurationService.loadLibraryAnnotations(libraryNameAndConfigurationFilePathAndAnnotationsFilePath);
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
        libraryConfigurationTriple.setLibraryName(Configuration.CORE_LIBRARY_NAME);
        libraryConfigurationTriple.setConfigurationFilePath(Configuration.CORE_PROPERTIES_FILE_PATH);
        libraryConfigurationTriple.setAnnotationsFilePath("/configuration/DataStructuresAnnotations.prop");
        libraryNamesAndConfigurationFilePathsAndAnnotationsFilePaths.add(libraryConfigurationTriple);
    }
    
    
    private void loadCoreProperties()
    {
        Pair<String, String> libraryNameAndConfigurationFilePathAndAnnotationsFilePath = new Pair<String, String>();
        libraryNameAndConfigurationFilePathAndAnnotationsFilePath.setOne(Configuration.CORE_LIBRARY_NAME);
        libraryNameAndConfigurationFilePathAndAnnotationsFilePath.setTwo(Configuration.CORE_PROPERTIES_FILE_PATH);
        libraryNamesAndConfigurationFilePathsAndAnnotationsFilePaths.add(libraryNameAndConfigurationFilePathAndAnnotationsFilePath);
        
    }
    
    
    public OrionObject(Set<Triple<String, String, String>> libraryNamesAndConfigurationFilePathsAndAnnotationsFilePaths)
    {
        //call the default constructor to initialise the core
        this();
        //when this constructor is run that means that the object being created
        //belogns to a project other than the core. The following vars are
        //overwritten by the other project, essentially
        libraryNamesAndConfigurationFilePaths.clear();
        libraryNames.addAll(libraryNames);
        libraryConfigurationFilePaths.addAll(libraryConfigurationFilePaths);
        libraryAnnotationsFilePaths.addAll(libraryAnnotationsFilePaths); 
        configurationService.loadProperties(libraryNames, libraryConfigurationFilePaths);
        
        if(libraryNames != null && !libraryNames.isEmpty())
        {
            for(String libraryName : libraryNames)
            {
                annotationsConfigurationService.loadLibraryAnnotations(libraryName, libraryAnnotationsFilePaths);
            }
        }
        
        annotationsProcessorService.processAllAnnotations(this);
    }
}
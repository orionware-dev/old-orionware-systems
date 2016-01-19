package core.annotations.configuration.tasks;

import java.io.InputStream;
import java.util.Set;
import core.annotations.RegisteredAnnotation;
import core.annotations.configuration.AnnotationsConfigurationService;
import core.annotations.filestream.AnnotationsFileStreamService;
import core.configuration.LibrariesConfigurationMapper;
import core.configuration.LibraryConfiguration;
import core.general.OrionProperties;
import core.services.OrionTask;

public class LoadLibrariesAnnotationsTask implements OrionTask
{
    private AnnotationsConfigurationService annotationsConfigurationService;
    private AnnotationsFileStreamService annotationsFileStreamService;
    private String currentAnnotationClass = null;
    private String currentAnnotationServiceClass = null;
    private String currentAnnotationServiceMethodToCall = null;
    private OrionProperties annotationsDeclarations;
    
    
    public void run(AnnotationsConfigurationService annotationsConfigurationService, AnnotationsFileStreamService annotationsFileStreamService, Set<LibraryConfiguration> librariesConfiguration)
    {
        this.annotationsConfigurationService = annotationsConfigurationService;
        
        if(librariesConfiguration != null)
        {
            registerAllLibrariesAnnotations(librariesConfiguration);
        }
    }
    
    
    private void registerAllLibrariesAnnotations(Set<LibraryConfiguration> librariesConfiguration)
    {
        for(LibraryConfiguration libraryConfiguration : librariesConfiguration)
        {
            if(libraryConfiguration.getAnnotationsFilePath() != null
                            && haveAnnotationsNotBeenRegistered(libraryConfiguration.getLibraryName()))
            {
                registerLibraryAnnotations(libraryConfiguration.getLibraryName(), libraryConfiguration.getAnnotationsFilePath());
                setAnnotationsAsRegistered(libraryConfiguration.getLibraryName());
            }
        }
    }
    
    
    private void registerLibraryAnnotations(String libraryName, String libraryAnnotationsFilePath)
    {
        annotationsDeclarations = loadLibraryAnnotationsDefinitions(libraryName, libraryAnnotationsFilePath);
        
        if(annotationsDeclarations.isNotEmpty())
        {
            int annotationCounter = 1;
            
            while(annotationsDeclarations.getProperty(libraryName + ".annotation." + annotationCounter) != null)
            {
                resolveCurrentAnnotationClass(libraryName, annotationCounter);
                resolveCurrentAnnotationServiceClass(libraryName, annotationCounter);
                resolveCurrentAnnotationServiceMethodToCall(libraryName, annotationCounter);
                registerLibraryAnnotation();
                ++annotationCounter;
            }
        }
    }
    
    
    private OrionProperties loadLibraryAnnotationsDefinitions(String libraryName, String libraryAnnotationsFilePath)
    {
        OrionProperties annotationsDeclarations = new OrionProperties();
        InputStream libraryAnnotationsFileStream = annotationsFileStreamService.getAnnotationsFileStream(libraryName, libraryAnnotationsFilePath);
        annotationsDeclarations.loadProperties(libraryAnnotationsFileStream);
        annotationsFileStreamService.closeResource(libraryAnnotationsFileStream);
        return annotationsDeclarations;
    }
    
    
    private void resolveCurrentAnnotationClass(String libraryName, int annotationCounter)
    {
        StringBuilder sb1 = new StringBuilder();
        sb1.append(libraryName);
        sb1.append(".annotation.");
        sb1.append(annotationCounter);
        currentAnnotationClass = annotationsDeclarations.getProperty(sb1.toString());
    }
    
    
    private void resolveCurrentAnnotationServiceClass(String libraryName, int annotationCounter)
    {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(libraryName);
        sb2.append(".annotation.service.");
        sb2.append(annotationCounter);
        currentAnnotationServiceClass = annotationsDeclarations.getProperty(sb2.toString());
    }
    
    
    private void resolveCurrentAnnotationServiceMethodToCall(String libraryName, int annotationCounter)
    {
        StringBuilder sb3 = new StringBuilder();
        sb3.append(libraryName);
        sb3.append(".annotation.service.method.to.call.");
        sb3.append(annotationCounter);
        currentAnnotationServiceMethodToCall = annotationsDeclarations.getProperty(sb3.toString());
    }
    
    
    private void registerLibraryAnnotation()
    {
        annotationsConfigurationService.registerAnnotation(new RegisteredAnnotation
            (currentAnnotationClass, currentAnnotationServiceClass, currentAnnotationServiceMethodToCall));
    }
    
    
    private boolean haveAnnotationsBeenRegistered(String libraryName)
    {
        if(LibrariesConfigurationMapper.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER.get(libraryName) != null)
        {
            return LibrariesConfigurationMapper.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER.get(libraryName);
        }
        else
        {
            return false;
        }
    }
    
    
    private boolean haveAnnotationsNotBeenRegistered(String libraryName)
    {
        return !haveAnnotationsBeenRegistered(libraryName);
    }
    
    
    private void setAnnotationsAsRegistered(String libraryName)
    {
        LibrariesConfigurationMapper.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER.put(libraryName, true);
    }
}
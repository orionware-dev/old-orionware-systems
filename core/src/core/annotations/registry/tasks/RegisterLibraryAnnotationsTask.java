package core.annotations.registry.tasks;

import core.annotations.RegisteredAnnotation;
import core.annotations.configuration.AnnotationsConfigurationService;
import core.annotations.configuration.tasks.LoadLibraryAnnotationsDefinitionsTask;
import core.annotations.registry.AnnotationsRegistrationService;
import core.configuration.LibraryConfiguration;
import core.general.OrionProperties;
import core.services.OrionTask;

public class RegisterLibraryAnnotationsTask implements OrionTask
{
    private OrionProperties annotationsDeclarations;
    private String currentAnnotationClass;
    private String currentAnnotationServiceClass;
    private String currentAnnotationServiceMethodToCall;
    private AnnotationsConfigurationService annotationsConfigurationService;
    
    
    public void run(AnnotationsConfigurationService annotationsConfigurationService, LoadLibraryAnnotationsDefinitionsTask loadLibraryAnnotationsDefinitionsTask, AnnotationsRegistrationService annotationsRegistrationService, LibraryConfiguration libraryConfiguration)
    {
        this.annotationsConfigurationService = annotationsConfigurationService;
        annotationsDeclarations = loadLibraryAnnotationsDefinitionsTask.run(annotationsConfigurationService, libraryConfiguration);
        
        if(annotationsDeclarations.isNotEmpty())
        {
            int annotationCounter = 1;
            
            while(annotationsDeclarations.getProperty(libraryConfiguration.getLibraryName() + ".annotation." + annotationCounter) != null)
            {
                resolveCurrentAnnotationClass(libraryConfiguration.getLibraryName(), annotationCounter);
                resolveCurrentAnnotationServiceClass(libraryConfiguration.getLibraryName(), annotationCounter);
                resolveCurrentAnnotationServiceMethodToCall(libraryConfiguration.getLibraryName(), annotationCounter);
                registerLibraryAnnotation();
                ++annotationCounter;
            }
        }
        
        annotationsRegistrationService.setAnnotationsAsRegisteredForLibrary(libraryConfiguration.getLibraryName());
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
}
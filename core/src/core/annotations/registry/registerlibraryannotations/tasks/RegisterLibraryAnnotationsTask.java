package core.annotations.registry.registerlibraryannotations.tasks;

import core.annotations.RegisteredAnnotation;
import core.annotations.loader.AnnotationsLoaderService;
import core.annotations.registry.AnnotationsRegistrationService;
import core.annotations.registry.annotationsdefinitions.tasks.LoadLibraryAnnotationsDefinitionsTask;
import core.configuration.LibraryConfiguration;
import core.general.OrionProperties;
import core.services.OrionTask;

public class RegisterLibraryAnnotationsTask implements OrionTask
{
    private OrionProperties annotationsDeclarations;
    private String currentAnnotationClass;
    private String currentAnnotationServiceClass;
    private String currentAnnotationServiceMethodToCall;
    private LoadLibraryAnnotationsDefinitionsTask loadLibraryAnnotationsDefinitionsTask = new LoadLibraryAnnotationsDefinitionsTask();
    private AnnotationsRegistrationService annotationsRegistrationService;
    
    
    public void run(AnnotationsRegistrationService annotationsRegistrationService, AnnotationsLoaderService annotationsLoaderService, LibraryConfiguration libraryConfiguration)
    {
        this.annotationsRegistrationService = annotationsRegistrationService;
        annotationsDeclarations = loadLibraryAnnotationsDefinitionsTask.run(annotationsLoaderService, libraryConfiguration);
        
        if(annotationsDeclarations.isNotEmpty())
        {
            int annotationCounter = 1;
            StringBuilder sb = new StringBuilder();
            sb.append(libraryConfiguration.getLibraryName());
            sb.append(".annotation.");
            sb.append(annotationCounter);
            String annotationDeclaration = sb.toString();
            
            while(currentAnnotationIsDeclared(annotationDeclaration))
            {
                resolveCurrentAnnotationClass(libraryConfiguration.getLibraryName(), annotationCounter);
                resolveCurrentAnnotationServiceClass(libraryConfiguration.getLibraryName(), annotationCounter);
                resolveCurrentAnnotationServiceMethodToCall(libraryConfiguration.getLibraryName(), annotationCounter);
                registerLibraryAnnotation();
                ++annotationCounter;
                sb = new StringBuilder();
                sb.append(libraryConfiguration.getLibraryName());
                sb.append(".annotation.");
                sb.append(annotationCounter);
                annotationDeclaration = sb.toString();
            }
        }
        
        annotationsRegistrationService.setAnnotationsAsRegisteredForLibrary(libraryConfiguration.getLibraryName());
    }
    
    
    private boolean currentAnnotationIsDeclared(String annotationDeclaration)
    {
        return annotationsDeclarations.doesPropExist(annotationDeclaration);
    }
    
    
    private void resolveCurrentAnnotationClass(String libraryName, int annotationCounter)
    {
        StringBuilder sb1 = new StringBuilder();
        sb1.append(libraryName);
        sb1.append(".annotation.");
        sb1.append(annotationCounter);
        currentAnnotationClass = annotationsDeclarations.getProp(sb1.toString());
    }
    
    
    private void resolveCurrentAnnotationServiceClass(String libraryName, int annotationCounter)
    {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(libraryName);
        sb2.append(".annotation.service.");
        sb2.append(annotationCounter);
        currentAnnotationServiceClass = annotationsDeclarations.getProp(sb2.toString());
    }
    
    
    private void resolveCurrentAnnotationServiceMethodToCall(String libraryName, int annotationCounter)
    {
        StringBuilder sb3 = new StringBuilder();
        sb3.append(libraryName);
        sb3.append(".annotation.service.method.to.call.");
        sb3.append(annotationCounter);
        currentAnnotationServiceMethodToCall = annotationsDeclarations.getProp(sb3.toString());
    }
    
    
    private void registerLibraryAnnotation()
    {
        annotationsRegistrationService.registerAnnotation(new RegisteredAnnotation
            (currentAnnotationClass, currentAnnotationServiceClass, currentAnnotationServiceMethodToCall));
    }
}
package core.configuration;

import core.general.OrionConfiguration;

public class RegisteredAnnotation extends OrionConfiguration
{
    private String annotationClass;
    private String annotationService;
    private String annotationServiceMethodToCall;
    
    
    public RegisteredAnnotation(String annotationClass, String annotationService, String annotationServiceMethodToCall)
    {
        this.annotationClass = annotationClass;
        this.annotationService = annotationService;
        this.annotationServiceMethodToCall = annotationServiceMethodToCall;
    }


    public String getAnnotationClass()
    {
        return this.annotationClass;
    }


    public String getAnnotationService()
    {
        return this.annotationService;
    }


    public String getAnnotationServiceMethodToCall()
    {
        return this.annotationServiceMethodToCall;
    }
}
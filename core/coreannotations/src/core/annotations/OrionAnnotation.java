package core.annotations;

public class OrionAnnotation
{
    private String annotationClass;
    private String annotationService;
    private String annotationServiceMethodToCall;
    
    
    public OrionAnnotation(String annotationClass, String annotationService, String annotationServiceMethodToCall)
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
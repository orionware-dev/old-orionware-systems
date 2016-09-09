package annotations;

import java.util.ArrayList;
import java.util.List;

public class OrionAnnotation extends AnnotationObject
{
    private String annotationClass;
    private List<AnnotationType> annotationTypes;
    private String annotationService;
    private String annotationServiceMethodToCall;


    public OrionAnnotation(String annotationClass, List<AnnotationType> annotationTypes, String annotationService, String annotationServiceMethodToCall)
    {
        this.annotationClass = annotationClass;
        
        if(annotationTypes != null)
        {
            this.annotationTypes = annotationTypes;
        }
        else
        {
            this.annotationTypes = new ArrayList<AnnotationType>();
        }
        
        this.annotationService = annotationService;
        this.annotationServiceMethodToCall = annotationServiceMethodToCall;
    }


    public String getAnnotationClass()
    {
        return this.annotationClass;
    }
    
    
    public List<AnnotationType> getAnnotationTypes()
    {
        return this.annotationTypes;
    }
    
    
    public void addAnnotationType(AnnotationType annotationType)
    {
        getAnnotationTypes().add(annotationType);
    }


    public String getAnnotationService()
    {
        return this.annotationService;
    }


    public String getAnnotationServiceMethodToCall()
    {
        return this.annotationServiceMethodToCall;
    }


    @Override
    public int hashCode()
    {
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + this.getAnnotationClass().hashCode();
        hash = defaultPrimeNumberForHashing * hash + this.getAnnotationTypes().hashCode();
        hash = defaultPrimeNumberForHashing * hash + this.getAnnotationService().hashCode();
        hash = defaultPrimeNumberForHashing * hash + this.getAnnotationServiceMethodToCall().hashCode();
        return hash;
    }


    @Override
    public boolean equals(Object object)
    {
        if(object == null || object.getClass() != getClass())
        {
            return false;
        }
        else
        {
            OrionAnnotation otherOrionAnnotation = (OrionAnnotation)object;

            if(this.getAnnotationClass().equals(otherOrionAnnotation.getAnnotationClass())
                   && this.getAnnotationTypes().equals(otherOrionAnnotation.getAnnotationTypes())
                   && this.getAnnotationService().equals(otherOrionAnnotation.getAnnotationService())
                   && this.getAnnotationServiceMethodToCall().equals(otherOrionAnnotation.getAnnotationServiceMethodToCall()))
            {
                return true;
            }
        }

        return false;
    }
}
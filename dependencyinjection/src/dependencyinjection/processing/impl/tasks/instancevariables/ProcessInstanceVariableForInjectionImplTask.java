package dependencyinjection.processing.impl.tasks.instancevariables;

import java.lang.reflect.Field;
import annotations.extraction.AnnotationsExtractionService;
import annotations.extraction.impl.AnnotationsExtractionServiceImpl;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import dependencyinjection.annotation.InjectorImpl;
import reflection.classes.ReflectionClassesService;
import reflection.classes.impl.ReflectionClassesServiceImpl;
import reflection.instancevariables.access.ReflectionInstanceVariablesAccessService;
import reflection.instancevariables.access.impl.ReflectionInstanceVariablesAccessServiceImpl;

public class ProcessInstanceVariableForInjectionImplTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private static final String IMPL_PACKAGE = ".impl.";
    private static final String IMPL_CLASS_NAME_SUFFIX = "Impl";
    private ReflectionClassesService reflectionClassesService = new ReflectionClassesServiceImpl();
    private ReflectionInstanceVariablesAccessService reflectionInstanceVariablesAccessService = new ReflectionInstanceVariablesAccessServiceImpl();
    private static AnnotationsExtractionService annotationsExtractionService = new AnnotationsExtractionServiceImpl();;


    public void run(Object object, Field instanceVariable)
    {
        reflectionInstanceVariablesAccessService.makeInstanceVariableAccessible(instanceVariable);
        InjectorImpl injection = (InjectorImpl)annotationsExtractionService.extractAnnotationFromInstanceVariable(instanceVariable, InjectorImpl.class);

        if(injection != null)
        {
            processInjection(object, instanceVariable, injection);
        }
    }


    private void processInjection(Object object, Field instanceVariable, InjectorImpl injection)
    {
        String classToInjectString = instanceVariable.getType().getName();
        int indexOfLastDot = classToInjectString.lastIndexOf(".");
        String className = classToInjectString.substring(indexOfLastDot + 1);
        classToInjectString = classToInjectString.substring(0, indexOfLastDot);
        StringBuilder sb = new StringBuilder(classToInjectString).append(IMPL_PACKAGE).append(className).append(IMPL_CLASS_NAME_SUFFIX);
        classToInjectString = sb.toString();

        try
        {
            instanceVariable.set(object, reflectionClassesService.instantiateClass(classToInjectString));
        }
        catch(IllegalArgumentException exception)
        {
            exception.printStackTrace();
        }
        catch(IllegalAccessException exception)
        {
            exception.printStackTrace();
        }
    }
}
package core.dependencyinjection.tasks;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import core.OrionObject;
import core.dependencyinjection.Injector;
import core.reflection.ReflectionService;
import core.services.OrionTask;

public class ProcessDependenciesTask implements OrionTask
{
    private OrionObject object;
    private ReflectionService reflectionService;
    
    
    public void run(OrionObject object, ReflectionService reflectionService)
    {
        this.object = object;
        this.reflectionService = reflectionService;
        //Arrays.stream(reflectionService.getMethodsArray(object))
            //.forEach(this::processMethod);
        Arrays.stream(reflectionService.getConstructorsArray(object))
        .forEach(this::processConstructor);
    }
    
    
    private void processConstructor(Constructor<?> constructor)
    {
        Injector injection = extractAnnotationFromConstructor(constructor);
        
        if(injection != null)
        {
            processInjection(constructor, injection);
        }
    }
    
    
    /*private void processMethod(Method method)
    {
        reflectionService.makeMethodAccessible(method);
        Injector injection = extractAnnotationFromMethod(method);
        
        if(injection != null)
        {
            processInjection(method, injection);
        }
    }*/
    
    
    private Injector extractAnnotationFromConstructor(Constructor<?> constructor)
    {
        return constructor.getAnnotation(Injector.class);
    }
    
    
    private Injector extractAnnotationFromMethod(Method method)
    {
        return method.getAnnotation(Injector.class);
    }
    
    
    private void processInjection(Constructor<?> constructor, Injector injection)
    {
        //String classToInject = injection.ID();
        
        try
        {
            Class<?>[] constructorParameters = constructor.getParameterTypes();
            
            if(constructorParameters != null)
            {
                Object[] constructorParametersObjects = new Object[constructorParameters.length];
                int constructorParameterCounter = 0;
                
                for(Class<?> constructorParameter : constructorParameters)
                {
                    constructorParametersObjects[constructorParameterCounter] = Class.forName(constructorParameter.getName()).newInstance();
                    ++constructorParameterCounter;
                }
                
                reflectionService.callConstructor(constructor, constructorParametersObjects);
            }
        }
        catch(InstantiationException exception)
        {
            exception.printStackTrace();
        }
        catch(IllegalAccessException exception)
        {
            exception.printStackTrace();
        }
        catch(ClassNotFoundException exception)
        {
            exception.printStackTrace();
        }
    }
    
    
    /*private void processInjection(Method method, Injector injection)
    {
        String classToInject = injection.ID();
        
        try
        {
            reflectionService.callMethod(method, object, Class.forName(classToInject).newInstance());
        }
        catch(InstantiationException exception)
        {
            exception.printStackTrace();
        }
        catch(IllegalAccessException exception)
        {
            exception.printStackTrace();
        }
        catch(ClassNotFoundException exception)
        {
            exception.printStackTrace();
        }
    }*/
}
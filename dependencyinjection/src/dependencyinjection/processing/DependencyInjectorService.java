package dependencyinjection.processing;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import dependencyinjection.DependencyInjectionService;
import dependencyinjection.annotation.Injector;

public interface DependencyInjectorService extends DependencyInjectionService
{
    public void processDependencies(Object object);
    
    
    public void processCustomInjectionForInstanceVariable(Object object, Injector injection, Field instanceVariable);
    
    
    public void processCustomInjectionForMethod(Object object, Injector injection, Method method);
    
    
    public void injectObjectToMethod(Object object, Object objectToInject, Method method);
    
    
    public void injectClassToMethod(Object object, Class<?> classToInject, Method method);
    
    
    public void injectClassToMethod(Object object, String classToInjectString, Method method);
    
    
    public void injectObjectToInstanceVariable(Object object, Object objectToInject, Field instanceVariable);
    
    
    public void injectClassToInstanceVariable(Object object, Class<?> classToInject, Field instanceVariable);
    
    
    public void injectClassToInstanceVariable(Object object, String classToInjectString, Field instanceVariable);
}
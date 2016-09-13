package reflection.instancevariables.retrieval;

import java.lang.reflect.Field;
import reflection.ReflectionService;

public interface ReflectionInstanceVariableRetrievalService extends ReflectionService
{
    public Field getDeclaredInstanceVariable(String instanceVariableName, Object object);
    
    
    public Field getDeclaredInstanceVariable(String instanceVariableName, Class<?> aClass);
    
    
    public Field getPrivateInstanceVariable(String instanceVariableName, Object object);
    
    
    public Field getPrivateInstanceVariable(String instanceVariableName, Class<?> aClass);
    
    
    public Field getDeclaredPublicInstanceVariable(String instanceVariableName, Object object);
    
    
    public Field getDeclaredPublicInstanceVariable(String instanceVariableName, Class<?> aClass);
    
    
    public Field getDeclaredProtectedInstanceVariable(String instanceVariableName, Object object);
    
    
    public Field getDeclaredProtectedInstanceVariable(String instanceVariableName, Class<?> aClass);
    
    
    public Field getInherittedInstanceVariable(String instanceVariableName, Object object);
    
    
    public Field getInherittedInstanceVariable(String instanceVariableName, Class<?> aClass);
    
    
    public boolean isPrivateInstanceVariable(Field instanceVariable);
    
    
    public boolean isProtectedInstanceVariable(Field instanceVariable);
    
    
    public boolean isPublicInstanceVariable(Field instanceVariable);
}
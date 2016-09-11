package reflection.services.accessibleobjects.instancevariables.retrieval;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import reflection.ReflectionService;

public interface ReflectionInstanceVariablesRetrievalService extends ReflectionService
{
    public Field[] getDeclaredInstanceVariablesArray(Object object);
    
    
    public Field[] getDeclaredInstanceVariablesArray(Class<?> aClass);
    
    
    public List<Field> getDeclaredInstanceVariables(Object object);
    
    
    public List<Field> getDeclaredInstanceVariables(Class<?> aClass);
    
    
    public Field[] getDeclaredPrivateInstanceVariablesArray(Object object);
    
    
    public Field[] getDeclaredPrivateInstanceVariablesArray(Class<?> aClass);
    
    
    public List<Field> getDeclaredPrivateInstanceVariables(Object object);
    
    
    public List<Field> getDeclaredPrivateInstanceVariables(Class<?> aClass);
    
    
    public Field[] getDeclaredProtectedInstanceVariablesArray(Object object);
    
    
    public Field[] getDeclaredProtectedInstanceVariablesArray(Class<?> aClass);
    
    
    public List<Field> getDeclaredProtectedInstanceVariables(Object object);
    
    
    public List<Field> getDeclaredProtectedInstanceVariables(Class<?> aClass);
    
    
    public Field[] getDeclaredPublicInstanceVariablesArray(Object object);
    
    
    public Field[] getDeclaredPublicInstanceVariablesArray(Class<?> aClass);
    
    
    public List<Field> getDeclaredPublicInstanceVariables(Object object);
    
    
    public List<Field> getDeclaredPublicInstanceVariables(Class<?> aClass);
    
    
    public Field[] getInherittedInstanceVariablesArray(Object object);
    
    
    public Field[] getInherittedInstanceVariablesArray(Class<?> aClass);
    
    
    public List<Field> getInherittedInstanceVariables(Object object);
    
    
    public List<Field> getInherittedInstanceVariables(Class<?> aClass);
    
    
    public Field[] getAllInstanceVariablesArray(Object object);
    
    
    public Field[] getAllInstanceVariablesArray(Class<?> aClass);
    
    
    public List<Field> getAllInstanceVariables(Object object);
    
    
    public List<Field> getAllInstanceVariables(Class<?> aClass);
}
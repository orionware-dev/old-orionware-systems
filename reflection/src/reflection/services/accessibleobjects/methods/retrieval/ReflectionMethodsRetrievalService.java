package reflection.services.accessibleobjects.methods.retrieval;

import java.lang.reflect.Method;
import java.util.List;
import reflection.ReflectionService;

public interface ReflectionMethodsRetrievalService extends ReflectionService
{
    public Method[] getDeclaredMethodsArray(Object object);


    public Method[] getDeclaredMethodsArray(Class<?> aClass);


    public List<Method> getDeclaredMethods(Object object);


    public List<Method> getDeclaredMethods(Class<?> aClass);


    public Method[] getDeclaredDefaultMethodsArray(Object object);


    public Method[] getDeclaredDefaultMethodsArray(Class<?> aClass);


    public List<Method> getDeclaredDefaultMethods(Object object);


    public List<Method> getDeclaredDefaultMethods(Class<?> aClass);


    public Method[] getPrivateMethodsArray(Object object);


    public Method[] getPrivateMethodsArray(Class<?> aClass);


    public List<Method> getPrivateMethods(Object object);


    public List<Method> getPrivateMethods(Class<?> aClass);


    public Method[] getDeclaredProtectedMethodsArray(Object object);


    public Method[] getDeclaredProtectedMethodsArray(Class<?> aClass);


    public List<Method> getDeclaredProtectedMethods(Object object);


    public List<Method> getDeclaredProtectedMethods(Class<?> aClass);


    public Method[] getDeclaredPublicMethodsArray(Object object);


    public Method[] getDeclaredPublicMethodsArray(Class<?> aClass);


    public List<Method> getDeclaredPublicMethods(Object object);


    public List<Method> getDeclaredPublicMethods(Class<?> aClass);


    public Method[] getInherittedMethodsArray(Object object);


    public Method[] getInherittedMethodsArray(Class<?> aClass);


    public List<Method> getInherittedMethods(Object object);


    public List<Method> getInherittedMethods(Class<?> aClass);


    public Method[] getAllMethodsArray(Object object);


    public Method[] getAllMethodsArray(Class<?> aClass);


    public List<Method> getAllMethods(Object object);


    public List<Method> getAllMethods(Class<?> aClass);
}
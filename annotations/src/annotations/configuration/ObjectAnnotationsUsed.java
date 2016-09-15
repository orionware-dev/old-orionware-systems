package annotations.configuration;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import annotations.OrionAnnotation;
import core.abstraction.OrionMapper;

public class ObjectAnnotationsUsed extends OrionMapper
{
    public static ConcurrentMap<Class<?>, CopyOnWriteArrayList<OrionAnnotation>> OBJECTS_ANNOTATIONS_USED_MAPPER;

    
    static
    {
        OBJECTS_ANNOTATIONS_USED_MAPPER = new ConcurrentHashMap<Class<?>, CopyOnWriteArrayList<OrionAnnotation>>();
    }
    
    
    public static CopyOnWriteArrayList<OrionAnnotation> getAnnotationsUsedByObject(Class<?> aClass)
    {
        return OBJECTS_ANNOTATIONS_USED_MAPPER.get(aClass);
    }
    
    
    public static CopyOnWriteArrayList<OrionAnnotation> getAnnotationsUsedByObject(Object object)
    {
        return getAnnotationsUsedByObject(object.getClass());
    }
    
    
    public static void registerObjectAnnotationsUsed(Class<?> aClass, CopyOnWriteArrayList<OrionAnnotation> annotationsUsed)
    {
        OBJECTS_ANNOTATIONS_USED_MAPPER.put(aClass, annotationsUsed);
    }
    
    
    public static void registerObjectAnnotationsUsed(Object object, CopyOnWriteArrayList<OrionAnnotation> annotationsUsed)
    {
        registerObjectAnnotationsUsed(object.getClass(), annotationsUsed);
    }
}
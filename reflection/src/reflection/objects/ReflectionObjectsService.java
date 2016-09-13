package reflection.objects;

import reflection.ReflectionService;

public interface ReflectionObjectsService extends ReflectionService
{
    public boolean isObjectNull(Object object);
    
    
    public boolean isObjectNotNull(Object object);
    
    
    public boolean areObjectsNull(Object... objects);
    
    
    public boolean areObjectsNotNull(Object... objects);
}
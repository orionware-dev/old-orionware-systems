package core.utilities.services.collections;

import java.util.Collection;

public interface CoreCollectionsService
{
    public boolean isCollectionNull(Collection<?> collection);
    
    
    public boolean isCollectionNotNull(Collection<?> collection);
    
    
    public boolean isCollectionEmpty(Collection<?> collection);
    
    
    public boolean isCollectionNotEmpty(Collection<?> collection);
}
package core.utilities.services.collections.impl;

import java.util.Collection;
import core.utilities.services.collections.CoreCollectionsService;
import core.utilities.services.strings.CoreStringsService;

public class CoreCollectionsServiceImpl implements CoreCollectionsService
{
    @Override
    public boolean isCollectionNull(Collection<?> collection)
    {
        return collection == null;
    }
    
    
    @Override
    public boolean isCollectionNotNull(Collection<?> collection)
    {
        return collection != null;
    }
    
    
    @Override
    public boolean isCollectionEmpty(Collection<?> collection)
    {
        return collection == null || collection.isEmpty();
    }
    
    
    @Override
    public boolean isCollectionNotEmpty(Collection<?> collection)
    {
        return collection != null && !collection.isEmpty();
    }
}
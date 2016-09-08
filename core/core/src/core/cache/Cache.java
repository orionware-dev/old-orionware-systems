package core.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import core.OrionSimpleObject;

public class Cache extends OrionSimpleObject
{
    private ConcurrentMap<Object, Object> cache;


    public Cache()
    {
        this.cache = new ConcurrentHashMap<Object, Object>();
    }


    public void addEntry(Object key, Object value)
    {
        getCache().put(key, value);
    }


    public ConcurrentMap<Object, Object> getCache()
    {
        return this.cache;
    }


    public void setCache(ConcurrentMap<Object, Object> cache)
    {
        this.cache = cache;
    }
}
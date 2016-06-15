package datastructures.maps;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class OrionConcurrentHashMap<T, T1, T2> extends ConcurrentHashMap<T1, T2> implements OrionMap<T, T1, T2>
{
    private static final long serialVersionUID = 2218876070379823151L;


    @Override
    public Object getFirst()
    {
        Entry<T1, T2> firstElement = null;
        Set<Entry<T1, T2>> entrySet = entrySet();
        Iterator<Entry<T1, T2>> iterator = entrySet.iterator();
        
        if(iterator.hasNext())
        {
            firstElement = iterator.next();
        }
        
        return firstElement;
    }


    @Override
    public Object getLast()
    {
        Entry<T1, T2> lastElement = null;
        Set<Entry<T1, T2>> entrySet = entrySet();
        Iterator<Entry<T1, T2>> iterator = entrySet.iterator();
        
        while(iterator.hasNext())
        {
            lastElement = iterator.next();
        }
        
        return lastElement;
    }


    @Override
    public int getSize()
    {
        return this.size();
    }
}
package datastructures.maps.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import datastructures.maps.OrionMap;

public class OrionHashMap<T, T1, T2> extends HashMap<T1, T2> implements OrionMap<T, T1, T2>
{
    private static final long serialVersionUID = -8197805466914391486L;


    @Override
    public Object getFirst()
    {
        Entry<T1, T2> firstElement = null;
        Set<Entry<T1, T2>> entries = entrySet();
        Iterator<Entry<T1, T2>> iterator = entries.iterator();
        
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
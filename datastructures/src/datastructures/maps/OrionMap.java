package datastructures.maps;

import java.util.Map;
import datastructures.DataStructure;

public interface OrionMap<T, T1, T2> extends Map<T1, T2>, DataStructure
{
    public Object getFirst();


    public Object getLast();


    public int getSize();
}
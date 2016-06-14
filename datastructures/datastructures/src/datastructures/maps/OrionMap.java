package datastructures.maps;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import datastructures.DataStructure;

public interface OrionMap<T, T1, T2> extends Map<T1, T2>, DataStructure
{
    public Object getFirst();


    public Object getLast();


    public int getSize();
}
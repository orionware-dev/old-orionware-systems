package datastructures.lists;

import java.util.List;
import java.util.function.Consumer;
import datastructures.general.DataStructure;

public interface OrionList<T> extends List<T>, DataStructure
{
    public void forAll(Consumer<?> action);
    
    
    public Object getFirst();
    
    
    public Object getLast();
    
    
    public Object getSize();
}
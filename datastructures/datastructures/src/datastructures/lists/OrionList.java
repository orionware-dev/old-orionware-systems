package datastructures.lists;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import datastructures.general.DataStructure;

public interface OrionList<T> extends List<T>, DataStructure
{
    public Stream<T> filter(Predicate<?> filterToApply);
    
    
    public void forAll(Consumer<?> action);
    
    
    public void forAll(Stream<T> stream, Consumer<?> action);
    
    
    public void filterAndLoop(Predicate<?> filterToApply, Consumer<?> action);
    
    
    public Object getFirst();
    
    
    public Object getLast();
    
    
    public Object getSize();
}
package datastructures.sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class OrionHashSet<T> extends HashSet<T> implements OrionSet<T>
{
    private static final long serialVersionUID = 6156781298396101372L;


    @SuppressWarnings("unchecked")
    @Override
    public Stream<T> filter(Predicate<?> filterToApply)
    {
        return stream().filter((Predicate<? super T>)filterToApply);
    }


    @SuppressWarnings("unchecked")
    @Override
    public void forAll(Consumer<?> action)
    {
        forEach((Consumer<? super T>)action);
    }


    @SuppressWarnings("unchecked")
    @Override
    public void forAll(Stream<T> stream, Consumer<?> action)
    {
        stream.forEach((Consumer<? super T>)action);
    }


    @Override
    public void filterAndLoop(Predicate<?> filterToApply, Consumer<?> action)
    {
        forAll(filter(filterToApply), action);
    }


    @Override
    public Object getFirst()
    {
        T firstElement = null;
        Iterator<T> iterator = iterator();
        
        if(iterator.hasNext())
        {
            firstElement = iterator.next();
        }
        
        return firstElement;
    }


    @Override
    public Object getLast()
    {
        T lastElement = null;
        Iterator<T> iterator = iterator();
        
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
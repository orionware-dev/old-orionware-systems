package datastructures.sets.impl;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import datastructures.sets.OrionSet;

public class OrionConcurrentSet<T> extends CopyOnWriteArraySet<T> implements OrionSet<T>
{
    private static final long serialVersionUID = -8923557322406477167L;


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
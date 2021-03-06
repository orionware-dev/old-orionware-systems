package datastructures.lists.impl;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import datastructures.lists.OrionList;

public class OrionArrayList<T> extends ArrayList<T> implements OrionList<T>
{
    private static final long serialVersionUID = -5786741979740114176L;


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
        return get(0);
    }


    @Override
    public Object getLast()
    {
        return get(this.size() - 1);
    }


    @Override
    public int getSize()
    {
        return this.size();
    }
}
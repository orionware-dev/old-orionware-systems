package datastructures.lists;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class OrionArrayList<T> extends ArrayList<T> implements OrionList<T>
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
        return get(0);
    }
    

    @Override
    public Object getLast()
    {
        return get(this.size() - 1);
    }


    @Override
    public Object getSize()
    {
        return this.size();
    }
}
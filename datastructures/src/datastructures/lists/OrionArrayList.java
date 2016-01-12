package datastructures.lists;

import java.util.ArrayList;
import java.util.function.Consumer;

public class OrionArrayList<T> extends ArrayList<T> implements OrionList<T>
{
    private static final long serialVersionUID = 6156781298396101372L;
    
    
    @SuppressWarnings("unchecked")
    @Override
    public void forAll(Consumer<?> action)
    {
        forEach((Consumer<? super T>)action);
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
package datastructures.streams.impl.tasks;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.stream.Stream;
import datastructures.DataStructuresObject;
import datastructures.DataStructuresTask;

public class ForEachTask<T> extends DataStructuresObject implements DataStructuresTask
{
    @SuppressWarnings("unchecked")
    public void run(Stream<T> stream, Consumer<?> action)
    {
        stream.forEach((Consumer<? super T>)action);
    }
    
    
    @SuppressWarnings("unchecked")
    public void run(Collection<T> collection, Consumer<?> action)
    {
        collection.forEach((Consumer<? super T>)action);
    }
}
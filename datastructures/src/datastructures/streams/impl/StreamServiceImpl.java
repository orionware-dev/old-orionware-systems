package datastructures.streams.impl;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.stream.Stream;
import datastructures.DataStructuresObject;
import datastructures.streams.StreamService;
import datastructures.streams.impl.tasks.ForEachTask;

public class StreamServiceImpl<T> extends DataStructuresObject implements StreamService<T>
{
    private ForEachTask<T> forEachTask = new ForEachTask<T>();
    
    
    @Override
    public void forEach(Stream<T> stream, Consumer<?> action)
    {
        forEachTask.run(stream, action);
    }

    
    @Override
    public void forEach(Collection<T> collection, Consumer<?> action)
    {
        forEachTask.run(collection, action);
    }
}
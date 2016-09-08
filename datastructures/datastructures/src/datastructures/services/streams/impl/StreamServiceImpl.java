package datastructures.services.streams.impl;

import java.util.function.Consumer;
import java.util.stream.Stream;
import core.dependencyinjection.annotations.Injector;
import datastructures.DataStructuresObject;
import datastructures.services.streams.StreamService;
import datastructures.services.streams.impl.tasks.ForEachTask;

public class StreamServiceImpl<T> extends DataStructuresObject implements StreamService<T>
{
    private ForEachTask<T> forEachTask;
    
    
    public StreamServiceImpl()
    {
        this.forEachTask = new ForEachTask<T>();
    }
    
    
    @Override
    public void forEach(Stream<T> stream, Consumer<?> action)
    {
        forEachTask.run(stream, action);
    }
}
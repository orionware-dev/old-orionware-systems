package datastructures.services.streams.impl;

import java.util.function.Consumer;
import java.util.stream.Stream;
import datastructures.services.DataStructuresServicesObject;
import datastructures.services.streams.StreamService;
import datastructures.services.streams.impl.tasks.ForEachTask;

public class StreamServiceImpl<T> extends DataStructuresServicesObject implements StreamService<T>
{
    @Override
    public void forEach(Stream<T> stream, Consumer<?> action)
    {
        new ForEachTask<T>().run(stream, action);
    }
}
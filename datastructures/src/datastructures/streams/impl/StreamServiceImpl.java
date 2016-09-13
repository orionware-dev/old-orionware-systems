package datastructures.streams.impl;

import java.util.function.Consumer;
import java.util.stream.Stream;
import datastructures.DataStructuresObject;
import datastructures.streams.StreamService;
import datastructures.streams.impl.tasks.ForEachTask;

public class StreamServiceImpl<T> extends DataStructuresObject implements StreamService<T>
{
    @Override
    public void forEach(Stream<T> stream, Consumer<?> action)
    {
        new ForEachTask<T>().run(stream, action);
    }
}
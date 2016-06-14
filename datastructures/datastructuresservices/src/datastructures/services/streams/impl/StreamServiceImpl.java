package datastructures.services.streams.impl;

import java.util.function.Consumer;
import java.util.stream.Stream;
import datastructures.DataStructuresObject;
import datastructures.lists.OrionList;
import datastructures.services.lists.size.ListSizeService;
import datastructures.services.lists.size.impl.tasks.GetSizeTask;
import datastructures.services.streams.StreamService;
import datastructures.services.streams.impl.tasks.ForEachTask;

public class StreamServiceImpl<T> extends DataStructuresObject implements StreamService<T>
{
    @Override
    public void forEach(Stream<T> stream, Consumer<?> action)
    {
        new ForEachTask<T>().run(stream, action);
    }
}
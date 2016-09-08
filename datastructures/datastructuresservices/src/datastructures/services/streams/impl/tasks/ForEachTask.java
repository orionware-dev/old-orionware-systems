package datastructures.services.streams.impl.tasks;

import java.util.function.Consumer;
import java.util.stream.Stream;
import datastructures.DataStructuresTask;
import datastructures.services.DataStructuresServicesObject;

public class ForEachTask<T> extends DataStructuresServicesObject implements DataStructuresTask
{
    public ForEachTask()
    {
        
    }
    
    
    @SuppressWarnings("unchecked")
    public void run(Stream<T> stream, Consumer<?> action)
    {
        stream.forEach((Consumer<? super T>)action);
    }
}
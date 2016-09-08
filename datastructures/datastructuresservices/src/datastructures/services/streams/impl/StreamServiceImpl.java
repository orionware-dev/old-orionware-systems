package datastructures.services.streams.impl;

import java.util.function.Consumer;
import java.util.stream.Stream;
import core.dependencyinjection.annotations.Injector;
import datastructures.services.DataStructuresServicesObject;
import datastructures.services.streams.StreamService;
import datastructures.services.streams.impl.tasks.ForEachTask;

public class StreamServiceImpl<T> extends DataStructuresServicesObject implements StreamService<T>
{
    private ForEachTask<T> forEachTask;
    
    
    public StreamServiceImpl()
    {
        
    }
    
    
    @Override
    public void forEach(Stream<T> stream, Consumer<?> action)
    {
        forEachTask.run(stream, action);
    }


    @Injector(ID = "datastructures.services.streams.impl.tasks.ForEachTask")
    private void setForEachTask(ForEachTask<T> forEachTask)
    {
        this.forEachTask = forEachTask;
    }
}
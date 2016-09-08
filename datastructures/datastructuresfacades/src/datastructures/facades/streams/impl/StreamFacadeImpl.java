package datastructures.facades.streams.impl;

import java.util.function.Consumer;
import java.util.stream.Stream;
import core.dependencyinjection.annotations.Injector;
import datastructures.facades.DataStructuresFacadesObject;
import datastructures.facades.streams.StreamFacade;
import datastructures.services.streams.StreamService;
import datastructures.services.streams.impl.StreamServiceImpl;

public class StreamFacadeImpl<T> extends DataStructuresFacadesObject implements StreamFacade<T>
{
    private StreamService<T> streamService;
    
    
    public StreamFacadeImpl()
    {
        this.streamService = new StreamServiceImpl<T>();
    }


    @Override
    public void forEach(Stream<T> stream, Consumer<?> action)
    {
        streamService.forEach(stream, action);
    }
}
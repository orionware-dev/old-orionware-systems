package datastructures.facades.streams.impl;

import java.util.function.Consumer;
import java.util.stream.Stream;
import core.dependencyinjection.Injector;
import datastructures.facades.DataStructuresFacadesObject;
import datastructures.facades.streams.StreamFacade;
import datastructures.services.streams.StreamService;

public class StreamFacadeImpl<T> extends DataStructuresFacadesObject implements StreamFacade<T>
{
    private StreamService<T> streamService;
    
    
    public StreamFacadeImpl()
    {
        
    }


    @Override
    public void forEach(Stream<T> stream, Consumer<?> action)
    {
        streamService.forEach(stream, action);
    }


    @Injector(ID = "datastructures.services.streams.impl.StreamServiceImpl")
    private void setStreamService(StreamService<T> streamService)
    {
        this.streamService = streamService;
    }
}
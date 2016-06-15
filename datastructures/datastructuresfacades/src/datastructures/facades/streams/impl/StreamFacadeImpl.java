package datastructures.facades.streams.impl;

import java.util.function.Consumer;
import java.util.stream.Stream;
import core.dependencyinjection.Injector;
import datastructures.DataStructure;
import datastructures.facades.DataStructuresFacadesObject;
import datastructures.facades.lists.factory.ListFactoryFacade;
import datastructures.facades.sets.factory.SetFactoryFacade;
import datastructures.facades.size.DataStructureSizeFacade;
import datastructures.facades.streams.StreamFacade;
import datastructures.lists.OrionList;
import datastructures.services.lists.factory.ListFactoryService;
import datastructures.services.lists.factory.impl.ListFactoryServiceImpl;
import datastructures.services.sets.factory.SetFactoryService;
import datastructures.services.sets.factory.impl.SetFactoryServiceImpl;
import datastructures.services.size.DataStructureSizeService;
import datastructures.services.size.impl.DataStructureSizeServiceImpl;
import datastructures.services.streams.StreamService;
import datastructures.services.streams.impl.StreamServiceImpl;
import datastructures.sets.OrionSet;

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
package datastructures.facades.sets.factory.impl;

import core.dependencyinjection.Injector;
import datastructures.facades.DataStructuresFacadesObject;
import datastructures.facades.lists.factory.ListFactoryFacade;
import datastructures.facades.sets.factory.SetFactoryFacade;
import datastructures.lists.OrionList;
import datastructures.services.lists.factory.ListFactoryService;
import datastructures.services.lists.factory.impl.ListFactoryServiceImpl;
import datastructures.services.sets.factory.SetFactoryService;
import datastructures.services.sets.factory.impl.SetFactoryServiceImpl;
import datastructures.services.size.DataStructureSizeService;
import datastructures.sets.OrionSet;

public class SetFactoryFacadeImpl<T> extends DataStructuresFacadesObject implements SetFactoryFacade<T>
{
    private SetFactoryService<T> setFactoryService;
    
    
    public SetFactoryFacadeImpl()
    {
        this.setFactoryService = new SetFactoryServiceImpl<T>();
    }


    @Override
    public OrionSet<T> createEmptyHashSet()
    {
        return setFactoryService.createEmptyHashSet();
    }


    @Override
    public OrionSet<T> createEmptyConcurrentHashSet()
    {
        return setFactoryService.createEmptyConcurrentHashSet();
    }
}
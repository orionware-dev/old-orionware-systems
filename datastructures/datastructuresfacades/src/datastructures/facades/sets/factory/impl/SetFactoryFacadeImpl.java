package datastructures.facades.sets.factory.impl;

import datastructures.facades.DataStructuresFacadesObject;
import datastructures.facades.sets.factory.SetFactoryFacade;
import datastructures.services.sets.factory.SetFactoryService;
import datastructures.services.sets.factory.impl.SetFactoryServiceImpl;
import datastructures.sets.OrionSet;
import datastructures.sets.impl.OrionConcurrentSet;

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
    public OrionConcurrentSet<T> createEmptyConcurrentHashSet()
    {
        return setFactoryService.createEmptyConcurrentHashSet();
    }
}
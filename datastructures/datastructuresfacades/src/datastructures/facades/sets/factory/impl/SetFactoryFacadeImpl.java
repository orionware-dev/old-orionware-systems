package datastructures.facades.sets.factory.impl;

import core.dependencyinjection.annotations.Injector;
import datastructures.facades.DataStructuresFacadesObject;
import datastructures.facades.sets.factory.SetFactoryFacade;
import datastructures.services.sets.factory.SetFactoryService;
import datastructures.sets.OrionSet;
import datastructures.sets.impl.OrionConcurrentSet;

public class SetFactoryFacadeImpl<T> extends DataStructuresFacadesObject implements SetFactoryFacade<T>
{
    private SetFactoryService<T> setFactoryService;
    
    
    public SetFactoryFacadeImpl()
    {
        
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


    @Injector(ID = "datastructures.services.sets.factory.impl.SetFactoryServiceImpl")
    private void setSetFactoryService(SetFactoryService<T> setFactoryService)
    {
        this.setFactoryService = setFactoryService;
    }
}
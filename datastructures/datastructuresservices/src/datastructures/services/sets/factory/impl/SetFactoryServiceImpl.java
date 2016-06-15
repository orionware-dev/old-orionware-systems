package datastructures.services.sets.factory.impl;

import datastructures.services.DataStructuresServicesObject;
import datastructures.services.sets.factory.SetFactoryService;
import datastructures.services.sets.factory.impl.tasks.CreateEmptyConcurrentHashSetTask;
import datastructures.services.sets.factory.impl.tasks.CreateEmptyHashSetTask;
import datastructures.sets.OrionConcurrentSet;
import datastructures.sets.OrionSet;

public class SetFactoryServiceImpl<T> extends DataStructuresServicesObject implements SetFactoryService<T>
{
    @SuppressWarnings({"rawtypes", "unchecked"})
    public OrionSet<T> createEmptyHashSet()
    {
        return new CreateEmptyHashSetTask().run();
    }
    
    
    @Override
    public OrionConcurrentSet<T> createEmptyConcurrentHashSet()
    {
        return new CreateEmptyConcurrentHashSetTask<T>().run();
    }
}
package datastructures.services.lists.factory;

import datastructures.lists.OrionList;
import datastructures.services.factories.DataStructureFactory;

public interface ListFactoryService<T> extends DataStructureFactory
{
    public OrionList<T> createEmptyList(Class<T> listType);
}
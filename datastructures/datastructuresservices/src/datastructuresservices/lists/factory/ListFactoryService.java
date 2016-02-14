package datastructuresservices.lists.factory;

import datastructures.lists.OrionList;
import datastructuresservices.factories.DataStructureFactory;

public interface ListFactoryService<T> extends DataStructureFactory
{
    public OrionList<T> createEmptyList(Class<T> listType);
}
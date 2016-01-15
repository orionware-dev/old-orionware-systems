package datastructuresservices.lists.factory;

import datastructures.lists.OrionList;
import datastructuresservices.factories.DataStructureFactory;

public interface ListFactoryService extends DataStructureFactory
{
    public OrionList<?> createEmptyList();
}
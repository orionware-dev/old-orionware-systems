package datastructuresservices.factories.lists;

import datastructures.lists.OrionList;
import datastructuresservices.factories.DataStructureFactoryService;

public interface ListFactoryService<T> extends DataStructureFactoryService
{
    public OrionList<T> getEmptyList(T listType);
}
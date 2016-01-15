package datastructuresservices.factories.lists.impl;

import core.dependencyinjection.Injector;
import datastructures.lists.OrionList;
import datastructuresservices.DataStructureServiceObject;
import datastructuresservices.factories.lists.ListFactoryService;
import datastructuresservices.factories.lists.impl.tasks.GetEmptyListTask;

public class ListFactoryServiceImpl<T> extends DataStructureServiceObject implements ListFactoryService<T>
{
    private GetEmptyListTask<T> getEmptyListTask;
    
    
    @SuppressWarnings("unchecked")
    @Override
    public OrionList<T> getEmptyList(T listType)
    {
        return (OrionList<T>)getEmptyListTask.run(listType);
    }


    public GetEmptyListTask<T> getGetEmptyListTask()
    {
        return this.getEmptyListTask;
    }


    @Injector(ID = "datastructuresservices.factories.lists.impl.tasks.GetEmptyListTask")
    private void setGetEmptyListTask(GetEmptyListTask<T> getEmptyListTask)
    {
        this.getEmptyListTask = getEmptyListTask;
    }
}
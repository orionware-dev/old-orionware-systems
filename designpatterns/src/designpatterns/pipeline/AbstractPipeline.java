package designpatterns.pipeline;

import core.general.OrionContainer;
import core.orion.OrionObject;
import datastructures.lists.OrionList;
import datastructuresfacades.lists.size.ListSizeFacade;
import datastructuresfacades.lists.size.impl.ListSizeFacadeImpl;

public abstract class AbstractPipeline extends OrionObject implements OrionContainer
{
    private OrionList<AbstractFilter> filtersList;
    private ListSizeFacade dataStructureSizeFacade;
    
    
    public AbstractPipeline()
    {
        dataStructureSizeFacade = new ListSizeFacadeImpl();
    }
    
    
    public int getNumberOfFilters()
    {
        //return dataStructureSizeFacade.getSize(filtersList);
        if(filtersList != null)
        {
            return filtersList.size();
        }
        
        return 0;
    }
    
    
    public Object executeFilters()
    {
        if(filtersList != null && !filtersList.isEmpty())
        {
            filtersList.stream().forEach(AbstractFilter::executeFilter);
            return ((AbstractFilter)filtersList.getLast()).getFunctionResult();
        }
        
        return null;
    }
}
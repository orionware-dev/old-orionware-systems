package designpatterns.pipeline;

import datastructures.lists.OrionList;
import designpatterns.DesignPatternsObject;

public abstract class AbstractPipeline extends DesignPatternsObject
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
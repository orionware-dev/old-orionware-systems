package designpatterns.pipeline;

import datastructures.lists.OrionArrayList;
import datastructures.lists.OrionList;
import designpatterns.DesignPatternsObject;

public abstract class AbstractPipeline extends DesignPatternsObject
{
    private OrionList<AbstractFilter> filtersList;
    private Object lastFunctionResult;
    private boolean feedForwardTheResult;
    // private ListSizeFacade dataStructureSizeFacade;


    public AbstractPipeline(boolean feedForwardTheResult)
    {
        setFiltersList(new OrionArrayList<AbstractFilter>());
        setFeedForwardTheResult(feedForwardTheResult);
        // dataStructureSizeFacade = new ListSizeFacadeImpl();
    }


    public AbstractPipeline(boolean feedForwardTheResult, OrionList<AbstractFilter> filtersList)
    {
        setFeedForwardTheResult(feedForwardTheResult);
        
        if(filtersList != null)
        {
            setFiltersList(filtersList);
        }
        else
        {
            setFiltersList(new OrionArrayList<AbstractFilter>());
        }
        // dataStructureSizeFacade = new ListSizeFacadeImpl();
    }


    public int getNumberOfFilters()
    {
        // return dataStructureSizeFacade.getSize(filtersList);
        if(getFiltersList() != null)
        {
            return getFiltersList().size();
        }

        return 0;
    }


    public void addFilter(AbstractFilter filter)
    {
        getFiltersList().add(filter);
    }


    public OrionList<AbstractFilter> getFiltersList()
    {
        return this.filtersList;
    }


    public void setFiltersList(OrionList<AbstractFilter> filtersList)
    {
        this.filtersList = filtersList;
    }


    public Object getLastFunctionResult()
    {
        return this.lastFunctionResult;
    }


    public void setLastFunctionResult(Object lastFunctionResult)
    {
        this.lastFunctionResult = lastFunctionResult;
    }


    public boolean isFeedForwardTheResult()
    {
        return this.feedForwardTheResult;
    }


    public void setFeedForwardTheResult(boolean feedForwardTheResult)
    {
        this.feedForwardTheResult = feedForwardTheResult;
    }
}
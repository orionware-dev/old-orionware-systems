package designpatterns.pipeline;

import datastructures.lists.OrionList;
import datastructures.lists.impl.OrionArrayList;
import designpatterns.DesignPatternsObject;

public abstract class AbstractPipeline extends DesignPatternsObject
{
    private OrionList<AbstractFilter> filters;
    private Object lastFunctionResult;
    private boolean feedForwardTheResult;


    public AbstractPipeline(boolean feedForwardTheResult)
    {
        setFilters(new OrionArrayList<AbstractFilter>());
        setFeedForwardTheResult(feedForwardTheResult);
    }


    public AbstractPipeline(boolean feedForwardTheResult, OrionList<AbstractFilter> filters)
    {
        setFeedForwardTheResult(feedForwardTheResult);
        
        if(filters != null)
        {
            setFilters(filters);
        }
        else
        {
            setFilters(new OrionArrayList<AbstractFilter>());
        }
    }


    public int getNumberOfFilters()
    {
        if(getFilters() != null)
        {
            return getFilters().size();
        }

        return 0;
    }


    public void addFilter(AbstractFilter filter)
    {
        getFilters().add(filter);
    }


    public OrionList<AbstractFilter> getFilters()
    {
        return this.filters;
    }


    public void setFilters(OrionList<AbstractFilter> filters)
    {
        this.filters = filters;
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
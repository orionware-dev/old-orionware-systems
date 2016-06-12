package designpatterns.pipeline;

import datastructures.lists.OrionArrayList;
import datastructures.lists.OrionList;
import designpatterns.DesignPatternsObject;

public abstract class AbstractPipeline extends DesignPatternsObject
{
    private boolean isAProceduralPipeline;
    private OrionList<AbstractFilter> filtersList;
    //private ListSizeFacade dataStructureSizeFacade;
    
    
    public AbstractPipeline()
    {
        setAProceduralPipeline(true);
        setFiltersList(new OrionArrayList<AbstractFilter>());
        //dataStructureSizeFacade = new ListSizeFacadeImpl();
    }
    
    
    public AbstractPipeline(boolean isAProceduralPipeline, OrionList<AbstractFilter> filtersList)
    {
        setAProceduralPipeline(isAProceduralPipeline);
        
        if(filtersList != null)
        {
            setFiltersList(filtersList);
        }
        else
        {
            setFiltersList(new OrionArrayList<AbstractFilter>());
        }
        //dataStructureSizeFacade = new ListSizeFacadeImpl();
    }
    
    
    public int getNumberOfFilters()
    {
        //return dataStructureSizeFacade.getSize(filtersList);
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


    public boolean isAProceduralPipeline()
    {
        return this.isAProceduralPipeline;
    }


    public void setAProceduralPipeline(boolean isAProceduralPipeline)
    {
        this.isAProceduralPipeline = isAProceduralPipeline;
    }
}
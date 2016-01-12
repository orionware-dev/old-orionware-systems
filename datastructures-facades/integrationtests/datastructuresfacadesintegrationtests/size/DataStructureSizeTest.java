package datastructuresfacadesintegrationtests.size;

import org.junit.Before;
import org.junit.Test;
import datastructures.lists.OrionArrayList;
import datastructures.lists.OrionList;
import datastructuresfacades.size.DataStructureSizeFacade;
import datastructuresfacades.size.impl.DataStructureSizeFacadeImpl;
import org.junit.Assert;

public class DataStructureSizeTest
{
    @Before
    public void setUp() throws Exception
    {
        
    }
    
    
    @Test
    public void testDataStructureSize()
    {
        DataStructureSizeFacade dataStructureSizeFacade = new DataStructureSizeFacadeImpl();
        OrionList<String> dataStructure = new OrionArrayList<String>();
        dataStructure.add("1");
        dataStructure.add("2");
        dataStructure.add("3");
        Assert.assertEquals(3, dataStructureSizeFacade.getSize(dataStructure));
    }
}